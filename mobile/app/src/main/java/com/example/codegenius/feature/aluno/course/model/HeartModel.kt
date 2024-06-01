package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class CourseModel (
    val id: UUID,
    val title: String,
    val courseDescription: String,
    val contentDescription: String,
    val available: Boolean,
    val languages: List<LanguagesModel>,
    val status: String,
    val teacherName: String,
    val categoryModel: List<CategoryModel>
)