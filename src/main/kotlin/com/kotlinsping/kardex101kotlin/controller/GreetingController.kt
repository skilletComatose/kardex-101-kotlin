package com.kotlinsping.kardex101kotlin.controller

import com.kotlinsping.kardex101kotlin.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/greetings")
class GreetingController(
    private val greetingService: GreetingService
) {

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable name: String): Any {
        return mapOf(
         "name" to  greetingService.retrieveGreeting(name)
        )
    }
}