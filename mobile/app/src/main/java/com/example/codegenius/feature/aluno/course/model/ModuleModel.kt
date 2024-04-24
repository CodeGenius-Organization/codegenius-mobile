package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ModuleModel(
    val id: UUID,
    val name: String,
    val moduleOrder: Int,
    val moduleLessonModel: List<ModuleLessonModel>
)