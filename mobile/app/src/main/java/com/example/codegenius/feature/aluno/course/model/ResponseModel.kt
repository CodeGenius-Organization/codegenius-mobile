package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ResponseModel (
    val id : UUID,
    val answer : String,
    val correct : Boolean,
    val explanation : String
)