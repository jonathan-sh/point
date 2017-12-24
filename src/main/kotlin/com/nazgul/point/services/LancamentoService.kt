package com.nazgul.point.services

import com.nazgul.point.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface LancamentoService {

    fun findByFuncionarioId(funcionarioId:String, pageRequest: PageRequest): Page<Lancamento>

    fun findById(id: String): Lancamento?

    fun save (lancamento: Lancamento): Lancamento

    fun remove (id: String)

}