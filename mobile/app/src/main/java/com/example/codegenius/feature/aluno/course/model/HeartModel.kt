package com.example.codegenius.feature.aluno.course.model

import java.time.LocalDateTime
import java.util.UUID

data class HeartModel (
    val hearts: Int,
    val lastUpdate: LocalDateTime,
    val fkUser: UUID
)