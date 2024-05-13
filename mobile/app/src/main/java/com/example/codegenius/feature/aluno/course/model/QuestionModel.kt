package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class QuestionModel (
    val id : UUID,
    val questionType : String,
    val statement : String,
    val testQuestion : Boolean,
    val responseModel : List<ResponseModel>
)