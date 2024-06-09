package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class QuestionModel (
    val id : UUID,
    val answer: String,
    val statement : String,
    val testQuestion : Boolean,
    val lesson_content : UUID,
    val respostas : List<ResponseModel>
)