package com.example.codegenius.feature.aluno.network

import com.example.codegenius.feature.aluno.course.repositories.CourseDetailRepositoryImpl
import com.example.codegenius.feature.aluno.course.repositories.CourseRepositoryImpl
import com.example.codegenius.feature.aluno.course.repositories.ICourseDetailRepository
import com.example.codegenius.feature.aluno.course.repositories.ICourseRepository
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseScreenViewModel
import com.example.codegenius.feature.aluno.login.repositories.ILoginRepository
import com.example.codegenius.feature.aluno.login.repositories.IRegisterRepository
import com.example.codegenius.feature.aluno.login.repositories.LoginRepositoryImpl
import com.example.codegenius.feature.aluno.login.repositories.RegisterRepositoryImpl
import com.example.codegenius.feature.aluno.login.ui.viewmodels.LoginScreenViewModel
import com.example.codegenius.feature.aluno.login.ui.viewmodels.RegisterScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ILoginRepository> {
        LoginRepositoryImpl()
    }
    single<IRegisterRepository>{
        RegisterRepositoryImpl()
    }
    single<ICourseRepository>{
        CourseRepositoryImpl()
    }
    single<ICourseDetailRepository>{
        CourseDetailRepositoryImpl()
    }

    viewModel {
        LoginScreenViewModel(get())
    }
    viewModel {
        RegisterScreenViewModel(get())
    }
    viewModel {
        CourseScreenViewModel(get())
    }
    viewModel {
        CourseDetailViewModel(get())
    }



}