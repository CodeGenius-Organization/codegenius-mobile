package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResponseModel
import java.util.UUID

val contentQuestionMock = listOf(
    QuestionModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        statement = "O que é uma linguagem de programação e qual é a sua finalidade?",
        answer = "Feitiçaria digital.",
        testQuestion = false,
        lessonContent = UUID.randomUUID(),
        responses = listOf(
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Um idioma especial para instruir computadores a realizar tarefas.",
                correct = true,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Um conjunto de regras para criar sopa.",
                correct = false,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Um livro de receitas para computadores.",
                correct = false,
                explanation = ""
            )
        )
    ),
    QuestionModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        statement = "Qual é a analogia usada no texto para descrever uma linguagem de programação?",
        testQuestion = true,
        answer = "Feitiçaria digital.",
        lessonContent = UUID.randomUUID(),
        responses = listOf(
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Feitiçaria digital.",
                correct = false,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Línguas antigas.",
                correct = true,
                explanation = ""
            ),
            ResponseModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                response = "Contos de fadas.",
                correct = false,
                explanation = ""
            )
        )
    )
)