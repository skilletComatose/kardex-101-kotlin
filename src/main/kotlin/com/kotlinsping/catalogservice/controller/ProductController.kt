package com.kotlinsping.catalogservice.controller

import com.kotlinsping.catalogservice.entity.Product
import com.kotlinsping.catalogservice.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping(path = [""])
    fun getAllProducts(): ResponseEntity<List<Product?>> {
        return ResponseEntity.ok(productService.findAll())
    }
}