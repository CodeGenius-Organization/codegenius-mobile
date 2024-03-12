package com.example.codegenius.feature.aluno.course.sampleData

import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.model.UserModel
import java.util.UUID

val socialUsersMock = listOf(
    UserModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        image = R.drawable.social_image,
        name = "Paula Maria",
        following = true),
    UserModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        image = R.drawable.social_image,
        name = "Maria Paula",
        following = false),
    UserModel(
        id = UUID.fromString("701cc766-1119-41e6-b6fd-b9b5013cecfa"),
        image = R.drawable.social_image,
        name = "Maria Paula",
        following = true)
)