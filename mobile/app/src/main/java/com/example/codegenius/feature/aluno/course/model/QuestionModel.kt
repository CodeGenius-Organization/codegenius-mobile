package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class QuestionModel (
    val id : UUID,
    val answer: String,
    val statement : String,
    val testQuestion : Boolean,
    val lessonContent : UUID,
    val responses : List<ResponseModel>
)