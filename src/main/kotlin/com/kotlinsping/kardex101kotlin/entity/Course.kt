package com.kotlinsping.kardex101kotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "courses")
data class Course (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,

    val name: String,

    val category: String
)