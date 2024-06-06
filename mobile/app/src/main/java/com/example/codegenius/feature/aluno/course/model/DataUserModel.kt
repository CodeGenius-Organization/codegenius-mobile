package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class DataUserModel(
 val id: UUID,
 val nome: String,
 val email: String,
 val password: String,
 val active: Boolean
)