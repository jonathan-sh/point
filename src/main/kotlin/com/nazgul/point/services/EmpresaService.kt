package com.nazgul.point.services

import com.nazgul.point.documents.Empresa

interface EmpresaService {

     fun findByCnpj(cnpj: String): Empresa?

     fun save(empresa: Empresa): Empresa
}