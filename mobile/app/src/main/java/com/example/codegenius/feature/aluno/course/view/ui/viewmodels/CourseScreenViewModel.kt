package com.example.codegenius.feature.aluno.course.view.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.repositories.ICourseRepository
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseScreenState
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenState
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CourseScreenViewModel(
    private val repository: ICourseRepository
) : ViewModel() {

     val state = MutableLiveData<CourseScreenState>(CourseScreenState.Loading)

    fun getAllCourse() {
        viewModelScope.launch {
            try {
                state.value = CourseScreenState.Loading
                val response = repository.getCourses()
                if (response.isSuccessful) {
                    Log.d("## Response", response.body().toString())
                    response.body()?.let { listCourses->
                        state.value = CourseScreenState.Success(data = listCourses)
                    }
                        ?: throw Exception("Sem cursos cadastrados!")
                } else {
                    throw Exception("ELSE - Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    502 -> "Timeout"
                    else -> "Catch - Erro desconhecido"
                }
                state.value = CourseScreenState.Error(message)
            }  catch (e: Exception) {
                state.value = CourseScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
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
