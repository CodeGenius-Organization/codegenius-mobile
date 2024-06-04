package com.example.codegenius.feature.aluno.course.model

import java.time.LocalDateTime
import java.util.UUID

data class LessonTestAttemptsModel(
    val id: UUID,
    val moduleLessonModel: ModuleLessonModel,
    val score: Int,
    val attemptStartDate: LocalDateTime,
    val attemptDuration: String
)
