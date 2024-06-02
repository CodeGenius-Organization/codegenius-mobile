package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.CategoryModel
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.LanguagesModel
import java.util.UUID

val contentCoursesMock = listOf(
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Informatica",
        courseDescription = "Curso muito show de informatica",
        contentDescription = "Só conteudo de qualidade de informatica",
        available = true,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Java"
            ),
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Kotlin"
            )
        ).toSet(),
        categoryModel = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Backend"
            )
        ).toSet()
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Jogos",
        courseDescription = "Curso muito show de jogos",
        contentDescription = "Só conteudo de qualidade de jogos",
        available = false,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Java"
            )
        ).toSet(),
        categoryModel = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Backend"
            )
        ).toSet()
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Machine learning",
        courseDescription = "Curso muito show de machine learning",
        contentDescription = "Só conteudo de qualidade de machine learning",
        available = true,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Python"
            )
        ).toSet(),
        categoryModel = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Database"
            )
        ).toSet()
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "IA",
        courseDescription = "Curso muito show de IA",
        contentDescription = "Só conteudo de qualidade de IA",
        available = true,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Python"
            )
        ).toSet(),
        categoryModel = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Database"
            ),
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Security"
            )
        ).toSet()
    )
)