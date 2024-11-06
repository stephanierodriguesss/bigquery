package com.study.bigquery.handler

import com.study.bigquery.service.CategoryService
import com.study.bigquery.domain.dto.CategoryDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun getCategory(): ResponseEntity<List<CategoryDTO>> {
        val categories = categoryService.execute()
        return ResponseEntity.ok().body(categories)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: String): ResponseEntity<Any> {
        categoryService.execute(id)
        return ResponseEntity.noContent().build()
    }
}