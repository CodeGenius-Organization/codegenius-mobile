package com.example.codegenius.feature.aluno.network

import com.example.codegenius.feature.aluno.login.LoginRepositoryImpl
import com.example.codegenius.feature.aluno.login.repositories.ILoginRepository
import com.example.codegenius.feature.aluno.login.ui.viewmodels.LoginScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ILoginRepository> {
        LoginRepositoryImpl()
    }
    viewModel {
        LoginScreenViewModel(get())
    }
}