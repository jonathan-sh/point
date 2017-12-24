package com.nazgul.point.dtos

import org.hibernate.validator.constraints.NotEmpty

data class LancamentoDTO
(
    @get:NotEmpty(message = "Data não pode ser vazia.")
    val data: String? = null,

    @get:NotEmpty(message = "Tipo não pode ser vazia.")
    val tipo:String? = null,

    val descricao: String? = null,
    val localizacao: String? = null,
    val id: String? = null
)