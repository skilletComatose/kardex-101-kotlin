package com.kotlinsping.catalogservice.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*


@Service
class MessageProvider(val messageSource: MessageSource) {


    fun getMessage(message: String): String {
        return messageSource.getMessage(message, null, Locale.getDefault())
    }
}

//fun getMessage(message: String): String = MessageProvider.getMessage(message)



