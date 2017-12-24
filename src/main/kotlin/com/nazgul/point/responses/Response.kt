package com.nazgul.point.responses

data class Response<T>
(
    val errors: ArrayList<String> = arrayListOf(),
    var data: T? = null
)