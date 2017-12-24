package com.nazgul.point.services.impl

import com.nazgul.point.documents.Empresa
import com.nazgul.point.repositorys.EmpresaRepository
import com.nazgul.point.services.EmpresaService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class EmpresaServiceImplTest {

    @Autowired
    val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "51263645000100"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testBuscarEmpresaPorCnpj() {
        val empresa: Empresa? = empresaService?.findByCnpj(CNPJ)
        Assert.assertNotNull(empresa)
    }

    @Test
    fun testSaveEmpresa(){
        val empresa: Empresa? = empresaService?.save(empresa())
        Assert.assertNotNull(empresa)
    }

    private fun empresa(): Empresa  = Empresa("Razao Social",CNPJ, "1")

}