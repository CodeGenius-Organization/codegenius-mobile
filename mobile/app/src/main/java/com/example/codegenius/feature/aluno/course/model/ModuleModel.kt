package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ModuleModel(
    val id: UUID,
    val moduleName: String,
    val moduleOrder: Int,
    val lessons: List<ModuleLessonModel>
)