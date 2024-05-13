package com.example.codegenius.feature.aluno.login.repositories

import com.example.codegenius.feature.aluno.login.models.Register
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.LoginService
import com.example.codegenius.feature.aluno.network.services.RegisterService
import retrofit2.Response


class RegisterRepositoryImpl: IRegisterRepository {
    override suspend fun postRegister(register: Register): Response<Void> {
        val api = ApiConfig
            .getInstance()
            .create(RegisterService::class.java)
        return api.postRegister(register);
    }
}