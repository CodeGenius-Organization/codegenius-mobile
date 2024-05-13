package com.example.codegenius.feature.aluno.network.services

import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.models.Register
import com.example.codegenius.feature.aluno.login.models.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("user/users/")
    suspend fun postRegister(@Body register: Register): Response<Void>
}