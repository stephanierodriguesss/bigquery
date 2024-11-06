package com.study.bigquery.handler

import com.study.bigquery.service.CategoryService
import com.study.bigquery.domain.dto.CategoryDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/category")
@RestController
class CategoryHandler(
    val categoryService: CategoryService
) {

    @PostMapping
    fun createCategory(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<Any> {
        val createdCategory = categoryService.execute(categoryDTO)
        return ResponseEntity.status(201).body(createdCategory)
    }
}