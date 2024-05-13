package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResponseModel
import java.util.UUID

val contentQuestionMock = listOf(
    QuestionModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        questionType = "",
        statement = "O que é uma linguagem de programação e qual é a sua finalidade?",
        testQuestion = false,
        responseModel = listOf(
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Um idioma especial para instruir computadores a realizar tarefas.",
                correct = true,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Um conjunto de regras para criar sopa.",
                correct = false,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Um livro de receitas para computadores.",
                correct = false,
                explanation = ""
            )
        )
    ),
    QuestionModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        questionType = "",
        statement = "Qual é a analogia usada no texto para descrever uma linguagem de programação?",
        testQuestion = true,
        responseModel = listOf(
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Feitiçaria digital.",
                correct = false,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Línguas antigas.",
                correct = true,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                answer = "Contos de fadas.",
                correct = false,
                explanation = ""
            )
        )
    )
)