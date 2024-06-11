package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ResponseModel (
    val resposta : String,
    val correta : Boolean,
    val explicacao : String,
    val fkQuestao : UUID
)