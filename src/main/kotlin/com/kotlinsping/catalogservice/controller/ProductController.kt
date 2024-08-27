package com.kotlinsping.catalogservice.controller

import com.kotlinsping.catalogservice.dto.ProductDto
import com.kotlinsping.catalogservice.dto.global.ResponseResult
import com.kotlinsping.catalogservice.service.ProductService
import com.kotlinsping.catalogservice.utils.ResponseList
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping(path = [""])
    fun getAllProducts(): ResponseList<ProductDto> {

        return productService.findAll()
            .let { ResponseEntity.status(it.status).body(it) }

    }
}