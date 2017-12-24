package com.nazgul.point.dtos

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF

data class CadastroPFDTO
(
        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min=3,max = 200, message = "Nome deve ser: >= 3 && <= 200")
        val nome: String,

        @get:NotEmpty(message = "Email não pode ser vazio.")
        @get:Length(min=3,max = 200, message = "Email deve ser: >= 3 && <= 200")
        @get:Email
        val email: String? = "",

        @get:NotEmpty(message = "Senha não pode ser vazio.")
        val senha: String? = null,

        @get:NotEmpty(message = "CPF não pode ser vazio.")
        @get:CPF(message = "CPF invalido")
        val cpf: String? = null,

        @get:NotEmpty(message = "CNPJ não pode ser vazio.")
        @get:CNPJ(message = "CNPJ invalido")
        val cnpj: String? = null,

        val  empresaId: String? = "",

        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,
        val  id: String? = null
)