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

    fun getHeart() {
        viewModelScope.launch {
            try {
                state.value = CourseDetailState.Loading
                val response = repository.getHeart()
                if (response.isSuccessful) {
                    response.body()?.let { hearts ->
                        state.value = CourseDetailState.HeartSuccess(data = hearts)
                        // Guardar no util
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
                    else -> "Catch - Erro desconhecido"
                }
                state.value = CourseDetailState.Error(message)
                Log.d("## ErroHeart", e.toString())
            }catch (e: Exception) {
                state.value = CourseDetailState.Error(
                    e.message ?: "Erro desconhecido"
                )
                Log.d("## ErroHeart", e.toString())
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
                if (response.isSuccessful) {
                    response.body()?.let { detail ->
                        state.value = CourseDetailState.CourseSuccess(data = detail)
                        Util.getInstance().modules = detail.modules
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
                Log.d("## Erro Course", e.toString())
            }  catch (e: Exception) {
                state.value = CourseDetailState.Error(
                    e.message ?: "Erro desconhecido"
                )
                Log.d("## Erro Course", e.toString())
            }
        }
    }

    fun postResultTest(resultExam: ResultTestModel, onNavigateLessonContent: () -> Unit) {
        viewModelScope.launch {
            try {
                state.value = CourseDetailState.Loading
                val response = repository.postResultTest(resultExam)
                Log.d("## Post ", response.toString())
                if (response.isSuccessful) {
                    onNavigateLessonContent()
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
                state.value = CourseDetailState.Error(message)
                Log.d("## Erro Course", e.toString())
            }   catch (e: Exception) {
                state.value = CourseDetailState.Error(
                    e.message ?: "Erro desconhecido"
                )
                Log.d("## Erro Course", e.toString())
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
    fun getListExercices(){
        viewModelScope.launch {
            try {
                state.value = CourseDetailState.Loading
                val response = repository.getListExercices()
                Log.d("## Rsp", response.toString())
                if (response.isSuccessful) {
                    response.body()?.let { listExercices ->
                        state.value = CourseDetailState.ExercicesSuccess(data = listExercices)
                        Util.getInstance().listExercices = listExercices
                        Log.d("## ListExercices",  listExercices.toString())
                    }
                        ?: throw Exception("Sem questões cadastrados!")
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
                Log.d("## Errinho2", e.message.toString())
            }
        }
    }

}