package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class CourseModel (
    val id: UUID,
    val title: String,
    val available: Boolean,
    val languages: List<LanguagesModel>,
    val categories: List<CategoryModel>
)