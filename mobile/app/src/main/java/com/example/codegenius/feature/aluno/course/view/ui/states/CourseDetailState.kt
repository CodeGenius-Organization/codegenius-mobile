package com.example.codegenius.feature.aluno.course.view.ui.states

import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.HeartModel
import com.example.codegenius.feature.aluno.course.model.LessonTestAttemptsModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel

sealed interface CourseDetailState {
    data object Loading : CourseDetailState
    data class CourseSuccess(
        val data: CourseDetailModule
    ) : CourseDetailState

    data class HeartSuccess(
        val data: HeartModel
    ) : CourseDetailState

    data class ExercicesSuccess(
        val data: List<QuestionModel>
    ) : CourseDetailState

    data class PostResultSuccess(
        val data: Void
    ) : CourseDetailState

    data class Error(
        val message: String
    ) : CourseDetailState
}