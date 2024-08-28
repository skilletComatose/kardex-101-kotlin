package com.kotlinsping.kardex101kotlin.controller

import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult
import com.kotlinsping.kardex101kotlin.dto.product.CreateProductDto
import com.kotlinsping.kardex101kotlin.dto.product.ProductDto
import com.kotlinsping.kardex101kotlin.service.ProductService
import com.kotlinsping.kardex101kotlin.utils.GlobalResponse
import com.kotlinsping.kardex101kotlin.utils.ResponseList
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping(path = [""])
    fun getAllProducts(): ResponseList<ProductDto> {
        val result: ResponseResult<List<ProductDto>> = productService.findAll()
        return ResponseEntity.status(result.status).body(result)
    }

    @PostMapping(path = [""])
    fun addNewProduct(@Valid @RequestBody product: CreateProductDto): GlobalResponse<ProductDto> {
        val result: ResponseResult<ProductDto> = productService.createProduct(product)
        return ResponseEntity.status(result.status).body(result)
    }
}