package com.kotlinsping.catalogservice.infraestructure

import com.kotlinsping.catalogservice.entity.Product
import com.kotlinsping.catalogservice.repository.ProductRepository
import com.kotlinsping.catalogservice.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService{
    companion object {
        const val CATEGORY_NOT_FOUND: String = "No existe la categoría"

        const val INTERNAL_SERVER_ERROR: String = "Error interno en el servicio"
    }

    override fun findAll(): List<Product?>  = productRepository.findAll();


}