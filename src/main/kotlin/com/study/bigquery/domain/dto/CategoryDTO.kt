package com.study.bigquery.domain.dto

import com.study.bigquery.domain.model.Category

data class CategoryDTO(
    val id: Int,
    val name: String
)

fun buildCategory(categoryDTO: CategoryDTO): Category {
    return Category(
        id = categoryDTO.id,
        name = categoryDTO.name
    )
}