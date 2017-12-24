package com.nazgul.point.dtos

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty


data class FuncionarioDTO
(
        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min=3,max = 200, message = "Nome deve ser: >= 3 && <= 200")
        val nome: String,

        @get:NotEmpty(message = "Email não pode ser vazio.")
        @get:Length(min=3,max = 200, message = "Email deve ser: >= 3 && <= 200")
        @get:Email
        val email: String? = "",

        val senha: String? = null,
        val cpf: String? = null,
        val valorHora: Double? = 0.0,
        val qtdHorasTrabalhoDia: Float? = 0.0f,
        val qtdHorasAlmoco: Float? = 0.0f,
        val id: String? = null
)