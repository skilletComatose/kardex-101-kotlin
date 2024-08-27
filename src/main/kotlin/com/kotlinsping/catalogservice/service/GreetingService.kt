package com.kotlinsping.catalogservice.service

interface GreetingService {
    fun retrieveGreeting(name: String) : String
}