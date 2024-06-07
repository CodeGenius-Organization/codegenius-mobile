package com.example.codegenius.feature.aluno.course.view.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import com.example.codegenius.feature.aluno.course.repositories.ICourseDetailRepository
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseDetailState
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.UUID

class CourseDetailViewModel(
    private val repository: ICourseDetailRepository
) : ViewModel() {

    val state = MutableLiveData<CourseDetailState>(CourseDetailState.Loading)

    fun getHeart(userId: UUID) {
        viewModelScope.launch {
            try {
                val response = repository.getHeart(userId)
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        Log.d("##Get Heart", detail.toString())
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
                    Log.d("## CourseDetail", response.body().toString())
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

    fun getCourseDetail() {
        viewModelScope.launch {
            try {
                state.value = CourseDetailState.Loading
                val response = repository.getCourse()
                Log.d("## Response", "${response}")
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        state.value = CourseDetailState.Success(data = detail)
                        Util.getInstance().modules = detail.modules.toList()
                        Log.d("## CourseDetail",  detail.toString())
                    }
                        ?: throw Exception("Sem detalhes do curso!")
                } else {
                    throw Exception("Erro desconhecido")
                }
            } catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    502 -> "Timeout"
                    else -> "Catch - Erro desconhecido"
                }
                state.value = CourseDetailState.Error(message)
                Log.d("## Errinho", e.toString())
            }  catch (e: Exception) {
                state.value = CourseDetailState.Error(
                    e.message ?: "Erro desconhecido"
                )
                Log.d("## Errinho", e.toString())
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