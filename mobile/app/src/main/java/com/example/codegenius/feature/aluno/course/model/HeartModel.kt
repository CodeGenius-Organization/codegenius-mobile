package com.example.codegenius.feature.aluno.course.model

import java.util.Date
import java.util.UUID

data class HeartModel (
    val hearts: Int,
    val lastUpdate: Date,
    val fkUser: UUID
)