package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class UserModel (
    val id: UUID,
    val image: Int,
    val name: String,
    val following: Boolean
)