package com.nazgul.point.repositorys

import com.nazgul.point.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository: MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa

}