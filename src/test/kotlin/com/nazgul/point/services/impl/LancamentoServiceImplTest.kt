package com.nazgul.point.services.impl

import com.nazgul.point.documents.Lancamento
import com.nazgul.point.enums.TipoEnum
import com.nazgul.point.repositorys.LancamentoRepository
import com.nazgul.point.services.LancamentoService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.collections.ArrayList

@RunWith(SpringRunner::class)
@SpringBootTest
class LancamentoServiceImplTest {

    @Autowired
    private val lancamentoService: LancamentoService? = null

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    private val ID: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito
                .given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(ID, PageRequest(0,10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
        BDDMockito.given(lancamentoRepository?.findOne(ID)).willReturn(lancamento())
        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java))).willReturn(lancamento())
    }

    @Test
    fun testFindByFuncionarioId() {
        val lancamento: Page<Lancamento>? = lancamentoService?.findByFuncionarioId(ID, PageRequest(0,10))
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testSave(){
        val lancamento: Lancamento? = lancamentoService?.save(lancamento())
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testeFindOne(){
        val lancamento: Lancamento? = lancamentoService?.findById(ID)
        Assert.assertNotNull(lancamento)
    }

    private fun lancamento(): Lancamento  =
    Lancamento(Date(),TipoEnum.INICIO_ALMOCO,ID)

}