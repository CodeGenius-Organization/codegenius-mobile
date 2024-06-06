package com.example.codegenius.feature.aluno.course.repositories

import android.util.Log
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.model.DataUserModel
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.CourseService
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import retrofit2.Response

class CourseRepositoryImpl: ICourseRepository {
    override suspend fun getUserByEmail(): Response<DataUserModel> {
        val api = ApiConfig
            .getInstance()
            .create(CourseService::class.java)
        return api.getUserByEmail(Util.getInstance().email, Util.getInstance().authToken.token);
    }

    override suspend fun getCourses(): Response<List<CourseModel>> {
            val api = ApiConfig
                .getInstance()
                .create(CourseService::class.java)
            Log.d("## TokenSer", "${Util.getInstance().authToken.token}")
            return api.getCourses("Bearer ${Util.getInstance().authToken.token}");
    }
}