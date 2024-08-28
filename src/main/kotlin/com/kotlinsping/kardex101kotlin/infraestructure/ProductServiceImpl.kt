package com.kotlinsping.kardex101kotlin.infraestructure

import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult
import com.kotlinsping.kardex101kotlin.dto.product.CreateProductDto
import com.kotlinsping.kardex101kotlin.dto.product.ProductDto
import com.kotlinsping.kardex101kotlin.entity.Category
import com.kotlinsping.kardex101kotlin.entity.Product
import com.kotlinsping.kardex101kotlin.mapper.ProductMapper
import com.kotlinsping.kardex101kotlin.repository.CategoryRepository
import com.kotlinsping.kardex101kotlin.repository.ProductRepository
import com.kotlinsping.kardex101kotlin.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
    private val categoryRepository: CategoryRepository
) : ProductService {
    companion object {
        const val CATEGORY_NOT_FOUND: String = "No existe la categoría"
        const val INTERNAL_SERVER_ERROR: String = "Error interno en el servicio"
        const val PRODUCT_ALREADY_EXISTS: String = "Este producto ya existe"
    }

    override fun findAll(): ResponseResult<List<ProductDto>> {
        return productRepository.findAll()
            .map(::toProductEntity)
            .let { ResponseResult.ok(it) }
    }

    override fun createProduct(createProductDto: CreateProductDto): ResponseResult<ProductDto> {
        return findCategoryBiId(createProductDto.categoryId)
            .map { toProductEntity(createProductDto, it) }
            .map { checkIfProductNameAlreadyExits(it) }
            .orElse(ResponseResult.notFound(CATEGORY_NOT_FOUND))
            .let { saveEntity(it) }
    }

    private fun toProductEntity(createProductDto: CreateProductDto, category: Category) =
        productMapper.toProduct(createProductDto).copy(category = category)

    private fun saveEntity(responseResult: ResponseResult<Product>): ResponseResult<ProductDto> =
        when (val data = responseResult.data) {
            null -> ResponseResult.of(null, responseResult.status, responseResult.errors)

            else -> {
                val savedProduct = saveProduct(data)
                ResponseResult.of(toDto(data), savedProduct.status, savedProduct.errors)
            }
        }

    private fun findCategoryBiId(categoryId: Int) = categoryRepository.findById(categoryId)

    private fun saveProduct(productOrError: Product): ResponseResult<Product> {
        return productRepository.save(productOrError)
            .let { ResponseResult.ok(it) }
    }

    private fun checkIfProductNameAlreadyExits(product: Product): ResponseResult<Product> {
        return productRepository.findByName(product.name)
            ?.let { ResponseResult.conflict(PRODUCT_ALREADY_EXISTS) } //en caso de que retorne valor
            ?: run { ResponseResult.ok(product) } // si el valor es null entonces
    }


    private fun toProductEntity(entity: Product) = toDto(entity)

    private fun toDto(data: Product) = productMapper.toProductDto(data)


}