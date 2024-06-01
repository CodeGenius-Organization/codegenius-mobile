package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ResultTestModel(
    val userId: UUID,
    val moduleLessonId: UUID,
    val score: Int,
    val attemptStartDate: String,
    val attemptDuration: String,
)