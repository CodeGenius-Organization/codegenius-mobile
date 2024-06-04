package com.example.codegenius.feature.aluno.course.view.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.course.repositories.ICourseRepository
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CourseScreenViewModel(
    private val repository: ICourseRepository
) : ViewModel() {

    fun getAllCourse() {
        viewModelScope.launch {
            try {
                val response = repository.getCourses("none", 0)
                if (response.isSuccessful) {
                    response.body()?.let { listCourse ->
                        Log.d("##Get Course", listCourse.toString())
                    }
                        ?: throw Exception("Sem cursos cadastrados!")
                } else {
                    throw Exception("Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    502 -> "Timeout"
                    else -> "Erro desconhecido"
                }
            }
        }
    }

    fun getUserByEmail() {
        viewModelScope.launch {
            try {
                val response = repository.getUserByEmail()
                if (response.isSuccessful) {
                    response.body()?.let { dataUser ->
                        Log.d("##Get Course", dataUser.toString())
                        Util.getInstance().dataUser = dataUser
                    }
                        ?: throw Exception("Sem cursos cadastrados!")
                } else {
                    throw Exception("Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    502 -> "Timeout"
                    else -> "Erro desconhecido"
                }
            }
        }
    }
}
