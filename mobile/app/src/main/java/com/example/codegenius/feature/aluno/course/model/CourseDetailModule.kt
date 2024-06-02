package com.example.codegenius.feature.aluno.course.model

data class CourseDetailModule(
    val title: String,
    val courseDescription: String,
    val contentDescription: String,
    val modules: Set<ModuleModel>
)
