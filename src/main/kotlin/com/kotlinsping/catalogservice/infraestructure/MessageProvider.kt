package com.kotlinsping.catalogservice.infraestructure

import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageProvider(val messageSource: MessageSource) {


    fun getMessage(message: String): String {
        return messageSource.getMessage(message, null, Locale.getDefault())
    }
}
