package com.example.codegenius.feature.aluno.network.services

import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.DataUserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CourseService {
    @GET("course/courses/")
    suspend fun getCourses(
        @Header("Authorization") authToken: String
    ): Response<List<CourseModel>>

    @GET("user/users/info/{email}")
    suspend fun getUserByEmail(
        @Path("email") email: String,
        @Header("Authorization") authToken: String
    ): Response<DataUserModel>
}