package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.ModuleLessonModel
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import java.util.UUID

val contentModuleMock = listOf(
    ModuleModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        name = "Introdução ao Java",
        moduleOrder = 1,
        moduleLessonModel = listOf(
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "O que é o java?",
                lessonOrder = 1,
                contentDescription = "Uma breve descrição sobre o que é o java e seus pontos fortes e fracos."
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "A importacia da orientação de objeto",
                lessonOrder = 2,
                contentDescription = "Uma breve descrição sobre o que é a orientação objeto e seus pontos fortes e fracos."
            )
        )
    ),
    ModuleModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        name = "Conclusão",
        moduleOrder = 3,
        moduleLessonModel = listOf(
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Agradecimentos",
                lessonOrder = 1,
                contentDescription = "Os meus mais sinceros agradecimentos pela sua compania durante esse curso e os meus parabéns pelo seu esforço."
            )
        )
    ),
    ModuleModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        name = "Integração com a API",
        moduleOrder = 2,
        moduleLessonModel = listOf(
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Fazendo uma requisição utilizando o http client",
                lessonOrder = 1,
                contentDescription = "Conceitos basicos de API e integração."
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Fazendo uma requisição utilizando o spring boot",
                lessonOrder = 3,
                contentDescription = "Explicando sobre o spring boot e integração."
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Explicando a arquitetura MVC",
                lessonOrder = 2,
                contentDescription = "Explicando o conceito e a importancia da arquitetura mvc."
            )
        )
    )
)