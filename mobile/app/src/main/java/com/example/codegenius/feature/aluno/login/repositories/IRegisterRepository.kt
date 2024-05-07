package com.example.codegenius.feature.aluno.login.repositories

import com.example.codegenius.feature.aluno.login.models.Register
import retrofit2.Response

interface IRegisterRepository {

    suspend fun postRegister(register: Register): Response<Void>
}