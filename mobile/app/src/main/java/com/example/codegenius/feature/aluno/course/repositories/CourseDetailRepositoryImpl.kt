package com.example.codegenius.feature.aluno.course.repositories

import android.util.Log
import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.HeartModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import com.example.codegenius.feature.aluno.network.ApiConfig
import com.example.codegenius.feature.aluno.network.services.CourseDetailService
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
import retrofit2.Response
import java.util.UUID

class CourseDetailRepositoryImpl: ICourseDetailRepository {
    override suspend fun getHeart(): Response<HeartModel> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.getHeart(Util.getInstance().dataUser.id, Util.getInstance().authToken.token);
    }

    override suspend fun patchHeart(userId: UUID, heart: Int): Response<HeartModel> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.patchHeart(userId, heart, Util.getInstance().authToken.token);
    }

    override suspend fun getCourse(): Response<CourseDetailModule> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        Log.d("## ID","${Util.getInstance().courseId}")
        return api.getCourse(Util.getInstance().courseId, "Bearer ${Util.getInstance().authToken.token}");
    }

    override suspend fun postResultTest(resultExam: ResultTestModel): Response<Void> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.postResultTest(resultExam, "Bearer ${Util.getInstance().authToken.token}");
    }

    override suspend fun postFeedback(feedback: FeedbackModel): Response<Void> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.postFeedback(feedback, Util.getInstance().authToken.token);
    }
    override suspend fun getListExercices(): Response<List<QuestionModel>> {
        val api = ApiConfig
            .getInstance()
            .create(CourseDetailService::class.java)
        return api.getListExercices(Util.getInstance().lessonContent.id, "Bearer "+ Util.getInstance().authToken.token);
    }

}