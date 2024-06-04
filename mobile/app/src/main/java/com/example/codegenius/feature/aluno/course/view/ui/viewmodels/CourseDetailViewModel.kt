package com.example.codegenius.feature.aluno.course.view.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import com.example.codegenius.feature.aluno.course.repositories.ICourseDetailRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.util.UUID

class CourseDetailViewModel(
    private val repository: ICourseDetailRepository
) : ViewModel() {

    fun getHeart(userId: UUID) {
        viewModelScope.launch {
            try {
                val response = repository.getHeart(userId)
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        Log.d("##Get Course", detail.toString())
                    }
                        ?: throw Exception("Sem vidas cadastradas!")
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

    fun patchHeart(userId: UUID) {
        viewModelScope.launch {
            try {
                val response = repository.patchHeart(userId, 2)
                if (response.isSuccessful) {
                    response.body()?.let { hearts ->
                        Log.d("##Get Course",hearts.toString())
                    }
                        ?: throw Exception("Sem hearts retornados!")
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

    fun getCourseDetail(courseId: UUID) {
        viewModelScope.launch {
            try {
                val response = repository.getCourse(courseId)
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        Log.d("##Get Course", detail.toString())
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

    fun postResultTest(resultExam: ResultTestModel) {
        viewModelScope.launch {
            try {
                val response = repository.postResultTest(resultExam)
                if (response.isSuccessful) {
                        Log.d("##Get Course", "Postei os resultados!")
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

    fun postFeedback(feedback: FeedbackModel) {
        viewModelScope.launch {
            try {
                val response = repository.postFeedback(feedback)
                if (response.isSuccessful) {
                    Log.d("##Get Course", "Postei os resultados!")
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
    fun getListExercices(lessonContentId: UUID){
        viewModelScope.launch {
            try {
                val response = repository.getListExercices(lessonContentId)
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        Log.d("##Get Course", detail.toString())
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