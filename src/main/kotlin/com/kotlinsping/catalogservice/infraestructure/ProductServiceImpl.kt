package com.kotlinsping.catalogservice.infraestructure

import com.kotlinsping.catalogservice.dto.ProductDto
import com.kotlinsping.catalogservice.dto.global.ResponseResult
import com.kotlinsping.catalogservice.entity.Product
import com.kotlinsping.catalogservice.mapper.ProductMapper
import com.kotlinsping.catalogservice.repository.ProductRepository
import com.kotlinsping.catalogservice.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
) : ProductService {
    companion object {
        const val CATEGORY_NOT_FOUND: String = "No existe la categoría"

        const val INTERNAL_SERVER_ERROR: String = "Error interno en el servicio"
    }

    override fun findAll(): ResponseResult<List<ProductDto>> {
        return productRepository.findAll()
            .map(::toEntity)
            .let { ResponseResult.ok(it) }
    }

    private fun toEntity(entity: Product) = productMapper.toProductDto(entity)

}