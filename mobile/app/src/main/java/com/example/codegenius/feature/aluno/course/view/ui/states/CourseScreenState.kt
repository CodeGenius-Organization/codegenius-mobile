package com.example.codegenius.feature.aluno.course.view.ui.states

import com.example.codegenius.feature.aluno.course.model.CourseModel

sealed interface CourseScreenState {
    data object Loading : CourseScreenState
    data class Success(
        val data: List<CourseModel>
    ) : CourseScreenState

    data class Error(
        val message: String
    ) : CourseScreenState
}