 package com.nazgul.point

import com.nazgul.point.documents.Empresa
import com.nazgul.point.documents.Funcionario
import com.nazgul.point.enums.PerfilEnum
import com.nazgul.point.repositorys.EmpresaRepository
import com.nazgul.point.repositorys.FuncionarioRepository
import com.nazgul.point.repositorys.LancamentoRepository
import com.nazgul.point.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PontyApplication(val empresaRepository: EmpresaRepository,
                       val funcionarioRepository: FuncionarioRepository,
                       val lancamentoRepository: LancamentoRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        empresaRepository.deleteAll()
        funcionarioRepository.deleteAll()
        lancamentoRepository.deleteAll()

        val empresa: Empresa = Empresa("Empresa", "10443887000146")
        empresaRepository.save(empresa)

        val admin: Funcionario = Funcionario("Admin", "admin@empresa.com",
                SenhaUtils().gerarBcrypt("123456"), "25708317000",
                PerfilEnum.ROLE_ADMIN, empresa.id!!)
        funcionarioRepository.save(admin)

        val funcionario: Funcionario = Funcionario("Funcionario",
                "funcionario@empresa.com", SenhaUtils().gerarBcrypt("123456"),
                "44325441557", PerfilEnum.ROLE_USUARIO, empresa.id!!)
        funcionarioRepository.save(funcionario)

        System.out.println("Empresa ID: " + empresa.id)
        System.out.println("Admin ID: " + admin.id)
        System.out.println("Funcionario ID: " + funcionario.id)
    }

}

 fun main(args: Array<String>) {
    SpringApplication.run(PontyApplication::class.java, *args)


}
