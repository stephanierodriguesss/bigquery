package com.study.bigquery.service

import com.google.cloud.bigquery.QueryJobConfiguration

import com.google.cloud.bigquery.QueryParameterValue
import com.study.bigquery.gateway.BigQueryGateway
import com.study.bigquery.domain.dto.CategoryDTO
import com.study.bigquery.domain.dto.buildCategory
import com.study.bigquery.domain.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryService(
    private val bigQueryGateway: BigQueryGateway
) {

    fun execute(categoryDTO: CategoryDTO): CategoryDTO {
        val category = buildCategory(categoryDTO)
        val jobConfig = queryCreateCategory(category)

        bigQueryGateway.executeQuery(jobConfig)
        return categoryDTO
    }

    fun execute(): List<CategoryDTO> {
        val jobConfig = queryGetCategory()

        val result = bigQueryGateway.executeQuery(jobConfig)

        return result.iterateAll().map { row ->
            val id = row.get("id").value as String
            val name = row.get("name").value as String

            CategoryDTO(
                id = id.toInt(),
                name = name
            )
        }.toList()
    }

    fun queryCreateCategory(category: Category): QueryJobConfiguration {
        val query = """INSERT INTO Vendas.Categoria (id, name) VALUES (@id, @name)"""

        val jobConfig = QueryJobConfiguration.newBuilder(query)
            .addNamedParameter("id", QueryParameterValue.int64(category.id))
            .addNamedParameter("name", QueryParameterValue.string(category.name))
            .build()

        return jobConfig
    }

    fun queryGetCategory(): QueryJobConfiguration {
        val query = """SELECT * FROM Vendas.Categoria LIMIT 100"""
        return QueryJobConfiguration.newBuilder(query).build()
    }
}