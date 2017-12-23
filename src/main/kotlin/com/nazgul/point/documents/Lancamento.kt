package com.nazgul.point.documents

import com.nazgul.point.enums.TipoEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Lancamento
(
    val data: Date,
    val tipo: TipoEnum,
    val funcionarioId: String,
    val descricao: String? = "",
    val localozacao: String? = null,
    @Id val id: String? = null
)