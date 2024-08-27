package com.kotlinsping.catalogservice.infraestructure

import com.kotlinsping.catalogservice.service.GreetingService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingService : GreetingService {

    // companion object  se usa para declarar valores staticso
    companion object  { const val STATIC_PROPERTY:String = "static value"}

    private val logger = KotlinLogging.logger {}


    @Value("\${example.message}")
    lateinit var message: String; //lateinit es inicialiazcion tardía (para inyectar dependencias o valores que será llenados por spring)

    override fun retrieveGreeting(name: String): String {
        logger.info { "uso de logger para kotlin : $name" }

        return "$message $name, im using $STATIC_PROPERTY".uppercase()
    }


}