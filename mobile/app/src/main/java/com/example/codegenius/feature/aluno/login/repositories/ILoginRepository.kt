package com.example.codegenius.feature.aluno.login.repositories

import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.models.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginRepository {
    @POST("user/login")
    suspend fun postLogin(@Body login: Login): Response<Token>
}