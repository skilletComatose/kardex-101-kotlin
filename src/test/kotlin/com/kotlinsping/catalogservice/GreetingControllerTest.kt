package com.kotlinsping.catalogservice

import com.kotlinsping.catalogservice.dto.course.CourseDto
import com.kotlinsping.catalogservice.service.GreetingService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class GreetingControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc


    @MockkBean
    lateinit var greetingService: GreetingService

    @Test
    fun test() {

       every  { greetingService.retrieveGreeting(any<String>()) } returns "carlos"


        mockMvc.perform(
            get("/v1/greetings/carlos")
        )
            .andExpect { status().isOk() }
            .andExpect { content().contentType(MediaType.APPLICATION_JSON) }
            .andExpect { jsonPath("$.name").value("carlos") }




    }


    @Test
    fun test2() {
        val carlos = CourseDto(name = "carlos", category = "lite")
        println(carlos)
    }



}