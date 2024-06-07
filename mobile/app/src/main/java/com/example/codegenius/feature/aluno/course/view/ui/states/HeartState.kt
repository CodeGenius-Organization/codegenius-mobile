package com.example.codegenius.feature.aluno.course.view.ui.states

import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.HeartModel

sealed interface HeartState {
    data object Loading : HeartState
    data class Success(
        val data: HeartModel
    ) : HeartState

    data class Error(
        val message: String
    ) : HeartState
}