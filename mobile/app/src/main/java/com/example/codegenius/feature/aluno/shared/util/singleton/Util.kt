package com.example.codegenius.feature.aluno.shared.util.singleton

import com.example.codegenius.feature.aluno.login.models.Token

class Util {

    lateinit var authToken: Token
    companion object{
        private val instance = Util()

        fun getInstance(): Util {
            return instance
        }
    }

    fun clearToken(){
        authToken = Token("")
    }
}