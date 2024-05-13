package com.example.codegenius.feature.aluno.login.repositories

import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.models.Token
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.LoginService
import retrofit2.Response

class LoginRepositoryImpl: ILoginRepository {
    override suspend fun postLogin(login: Login): Response<Token> {
        val api = ApiConfig
            .getInstance()
            .create(LoginService::class.java)
        return api.postLogin(login);
    }
}