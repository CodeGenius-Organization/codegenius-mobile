package com.example.codegenius.feature.aluno.course.repositories

import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.HeartModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.CourseDetailService
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import retrofit2.Response
import java.util.UUID

class CourseDetailRepositoryImpl: ICourseDetailRepository {
    override suspend fun getHeart(userId: UUID): Response<HeartModel> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.getHeart(userId, Util.getInstance().authToken.token);
    }

    override suspend fun patchHeart(userId: UUID, heart: Int): Response<HeartModel> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.patchHeart(userId, heart,  Util.getInstance().authToken.token);
    }

    override suspend fun getCourse(courseId: UUID): Response<Any> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.getCourse(courseId, Util.getInstance().authToken.token);
    }

    override suspend fun postResultTest(resultExam: ResultTestModel): Response<Any> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.postResultTest(resultExam, Util.getInstance().authToken.token);
    }

    override suspend fun postFeedback(feedback: FeedbackModel): Response<Void> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.postFeedback(feedback, Util.getInstance().authToken.token);
    }
    override suspend fun getListExercices(lessonContentId: UUID): Response<Any> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.getListExercices(lessonContentId, Util.getInstance().authToken.token);
    }

}