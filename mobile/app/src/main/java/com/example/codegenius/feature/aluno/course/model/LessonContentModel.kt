package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class LessonContentModel (
    val id: UUID,
    val title: String,
    val content: String
)