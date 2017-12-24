package com.nazgul.point.services.impl

import com.nazgul.point.documents.Lancamento
import com.nazgul.point.repositorys.LancamentoRepository
import com.nazgul.point.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun findByFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
    lancamentoRepository.findByFuncionarioId(funcionarioId,pageRequest)

    override fun findById(id: String): Lancamento? = lancamentoRepository.findOne(id)

    override fun save(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remove(id: String) = lancamentoRepository.delete(id)


}