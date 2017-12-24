package com.nazgul.point.dtos

data class EmpresaDTO
(
    val  razaoSocial: String,
    val cnpj:String,
    val  id: String? = null
)