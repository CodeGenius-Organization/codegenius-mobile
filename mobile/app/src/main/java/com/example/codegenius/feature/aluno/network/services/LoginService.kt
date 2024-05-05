package com.example.codegenius.feature.aluno.network.services

import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.models.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("user/login")
    suspend fun postLogin(@Body login: Login): Response<Token>
}