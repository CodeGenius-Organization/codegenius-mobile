package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class ResponseModel (
    val fkQuestao : UUID,
    val resposta : String,
    val correta : Boolean,
    val explicacao : String
)