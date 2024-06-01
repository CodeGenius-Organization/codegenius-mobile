package com.example.codegenius.feature.aluno.course.repositories

import com.example.codegenius.feature.aluno.course.model.CourseModel
import retrofit2.Response

interface ICourseRepository {
    suspend fun getCourses(category: String, courseLength: Int): Response<List<CourseModel>>
}