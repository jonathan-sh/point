package com.nazgul.point.services

import com.nazgul.point.documents.Empresa

interface EmpresaService {

     fun busca(cnpj: String): Empresa?

     fun salva(empresa: Empresa): Empresa
}