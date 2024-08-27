package com.kotlinsping.catalogservice.utils

import com.kotlinsping.catalogservice.dto.global.ResponseResult
import org.springframework.http.ResponseEntity


typealias GlobalResponse<T> = ResponseEntity<ResponseResult<T>>

typealias ResponseList<T> = GlobalResponse<List<T>>


