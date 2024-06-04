package com.example.codegenius.feature.aluno.course.repositories

import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.DataUserModel
import retrofit2.Response

interface ICourseRepository {

    suspend fun getUserByEmail(): Response<DataUserModel>
    suspend fun getCourses(category: String, courseLength: Int): Response<List<CourseModel>>
}