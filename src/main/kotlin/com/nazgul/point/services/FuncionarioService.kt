package com.nazgul.point.services

import com.nazgul.point.documents.Funcionario

interface FuncionarioService {

    fun save(funcionario: Funcionario): Funcionario

    fun findById(id: String): Funcionario

    fun findByCpf(cpnf: String): Funcionario

    fun findByEmail(email: String): Funcionario

}