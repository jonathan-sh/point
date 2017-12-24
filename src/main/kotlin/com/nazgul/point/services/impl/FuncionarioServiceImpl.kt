package com.nazgul.point.services.impl

import com.nazgul.point.documents.Funcionario
import com.nazgul.point.repositorys.FuncionarioRepository
import com.nazgul.point.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun save(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)

    override fun findByEmail(email: String): Funcionario = funcionarioRepository.findByEmail(email)

    override fun findByCpf(cpf: String): Funcionario = funcionarioRepository.findByCpf(cpf)

    override fun findById(id: String): Funcionario =  funcionarioRepository.findOne(id)

}