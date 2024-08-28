package com.kotlinsping.kardex101kotlin.utils

import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult
import org.springframework.http.ResponseEntity


typealias GlobalResponse<T> = ResponseEntity<ResponseResult<T>>

typealias ResponseList<T> = GlobalResponse<List<T>>


