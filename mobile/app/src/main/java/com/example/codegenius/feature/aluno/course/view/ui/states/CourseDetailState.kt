package com.example.codegenius.feature.aluno.course.view.ui.states

import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.CourseModel

sealed interface CourseDetailState {
    data object Loading : CourseDetailState
    data class Success(
        val data: CourseDetailModule
    ) : CourseDetailState

    data class Error(
        val message: String
    ) : CourseDetailState
}