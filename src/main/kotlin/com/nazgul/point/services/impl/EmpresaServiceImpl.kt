package com.nazgul.point.services.impl

import com.nazgul.point.documents.Empresa
import com.nazgul.point.repositorys.EmpresaRepository
import com.nazgul.point.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override
    fun busca(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override
    fun salva(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}