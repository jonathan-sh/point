package com.nazgul.point.utils

import org.junit.Test

import org.junit.Assert.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilsTest {


    private val SENHA = "123456"
    private val bCrytEncoder = BCryptPasswordEncoder();

    @Test
    fun testGerarHash() {
        val hash = SenhaUtils().gerarBcrypt(SENHA)
        assertTrue(bCrytEncoder.matches(SENHA,hash))
    }
}