package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.feature.aluno.course.model.CategoryModel
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.LanguagesModel
import java.util.UUID

val contentCoursesMock = listOf(
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Informatica",
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
        ),
        categories = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Backend"
            )
        )
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Jogos",
        available = false,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Java"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Backend"
            )
        )
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "Machine learning",
        available = true,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Python"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Database"
            )
        )
    ),
    CourseModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        title = "IA",
        available = true,
        languages = listOf(
            LanguagesModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                language = "Python"
            )
        ),
        categories = listOf(
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Database"
            ),
            CategoryModel(
                id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
                category = "Security"
            )
        )
    )
)