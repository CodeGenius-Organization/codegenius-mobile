package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.LessonContentModel
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
                contentDescription = "Uma breve descrição sobre o que é o java e seus pontos fortes e fracos.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "O que é o java?",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Considerações finais sobre o java",
                lessonOrder = 3,
                contentDescription = "Uma breve consideração sobre o java.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Considerações finais sobre o java",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "A importacia da orientação objeto",
                lessonOrder = 2,
                contentDescription = "Uma breve descrição sobre o que é a orientação objeto e seus pontos fortes e fracos.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "A importancia da orientação objeto",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
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
                contentDescription = "Os meus mais sinceros agradecimentos pela sua compania durante esse curso e os meus parabéns pelo seu esforço.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Agradecimentos",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
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
                contentDescription = "Conceitos basicos de API e integração.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Fazendo uma requisição utilizando o http client",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Considerações finais sobre o spring boot",
                lessonOrder = 4,
                contentDescription = "Uma breve consideração sobre o spring boot.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Considerações finais sobre o spring boot",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Fazendo uma requisição utilizando o spring boot",
                lessonOrder = 3,
                contentDescription = "Explicando sobre o spring boot e integração.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Fazendo uma requisição utilizando o spring boot",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            ),
            ModuleLessonModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                lessonTitle = "Explicando a arquitetura MVC",
                lessonOrder = 2,
                contentDescription = "Explicando o conceito e a importancia da arquitetura mvc.",
                lessonContentModel = LessonContentModel(
                    id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                    title = "Explicando a arquitetura MVC",
                    content = "Uma linguagem de programação é como um idioma especial que nós, humanos, usamos para conversar com computadores. Imagine que é como dar comandos mágicos para fazer o computador fazer coisas incríveis. É como ser um feiticeiro digital! Essas linguagens são como conjuntos de regras e símbolos que você usa para criar feitiços, ou seja, programas de computador. Esses programas são como histórias que você conta ao computador e ele entende e executa o que você disse."
                )
            )
        )
    )
)