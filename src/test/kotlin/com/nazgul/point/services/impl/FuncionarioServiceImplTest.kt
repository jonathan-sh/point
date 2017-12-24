package com.nazgul.point.services.impl

import com.nazgul.point.documents.Funcionario
import com.nazgul.point.enums.PerfilEnum
import com.nazgul.point.repositorys.FuncionarioRepository
import com.nazgul.point.services.FuncionarioService
import com.nazgul.point.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceImplTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    val  funcionarioService: FuncionarioService? = null

    private val EMAIL = "email@email.com"
    private val CPF = "000.000.000-00"
    private val ID = "1"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(funcionarioRepository?.findByEmail(EMAIL)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(CPF)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findOne(ID)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
    }

    @Test
    fun findByEmail() {
        val funcionario: Funcionario? = funcionarioService?.findByEmail(EMAIL)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun findByCpf() {
        val funcionario: Funcionario? = funcionarioService?.findByCpf(CPF)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun findById() {
        val funcionario: Funcionario? = funcionarioService?.findById(ID)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun save() {
        val funcionario: Funcionario? = funcionarioService?.save(funcionario())
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario  =
    Funcionario("Nome", EMAIL, SenhaUtils().gerarBcrypt("123456"),CPF,PerfilEnum.ROLE_USUARIO,ID)
}