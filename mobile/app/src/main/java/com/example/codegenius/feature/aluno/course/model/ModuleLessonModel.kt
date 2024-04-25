package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ModuleLessonModel (
    val id: UUID,
    val lessonTitle: String,
    val lessonOrder: Int,
    val contentDescription: String,
    val lessonContentModel: LessonContentModel
)