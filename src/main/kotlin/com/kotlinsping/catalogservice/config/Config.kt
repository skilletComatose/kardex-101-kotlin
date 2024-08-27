package com.kotlinsping.catalogservice.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

@Configuration
class Config {


    @Bean
    fun messageSource(): MessageSource {
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename(
            "classpath:./i18n/error.message"
        )
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }
}