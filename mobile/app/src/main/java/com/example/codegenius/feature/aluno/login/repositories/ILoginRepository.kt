package com.example.codegenius.feature.aluno.login.repositories

import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.models.Token
import retrofit2.Response

interface ILoginRepository {
    suspend fun postLogin(login: Login): Response<Token>
}