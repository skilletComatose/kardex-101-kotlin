package com.kotlinsping.kardex101kotlin.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    val productId: Int?,

    @Column(unique = true)
    val name: String,

    val description: String,

    val price: BigDecimal,

    @Column(name = "stock_quantity")
    val stockQuantity: Int,

    @Column(name = "image_url")
    val imageUrl: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category?,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime?,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime?
)