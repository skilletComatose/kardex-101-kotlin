package com.kotlinsping.kardex101kotlin.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "categories")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val categoryId: Int,

    @Column(nullable = false, unique = true)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime
)