package com.example.codegenius.feature.aluno.course.repositories

import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.CourseService
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import retrofit2.Response

class CourseRepositoryImpl: ICourseRepository {
    override suspend fun getCourses(
        category: String,
        courseLength: Int,
    ): Response<List<CourseModel>> {
            val api = ApiConfig
                .getInstance()
                .create(CourseService::class.java)
            return api.getCourses(category, courseLength, Util.getInstance().authToken.token);
    }
}