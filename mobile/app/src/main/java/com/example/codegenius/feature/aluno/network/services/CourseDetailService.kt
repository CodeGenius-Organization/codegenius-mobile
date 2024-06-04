package com.example.codegenius.feature.aluno.network.services

import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.HeartModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import java.util.UUID

interface CourseDetailService {

    @GET("user/hearts/{userId}")
    suspend fun getHeart(
        @Path("userId") userId: UUID,
        @Header("Authorization") authToken: String
    ): Response<HeartModel>

    @PUT("user/hearts/{userId}")
    suspend fun patchHeart(
        @Path("userId") userId: UUID,
        @Body heart: Int,
        @Header("Authorization") authToken: String
    ): Response<HeartModel>

    @GET("course/courses/{courseId}")
    suspend fun getCourse(
        @Path("courseId") courseId: UUID,
        @Header("Authorization") authToken: String
    ): Response<CourseDetailModule>

    @POST("course/test-attempts/")
    suspend fun postResultTest(
        @Body resultExam: ResultTestModel,
        @Header("Authorization") authToken: String
    ): Response<Void>

    @POST("/course/feedbacks")
    suspend fun postFeedback(
        @Body feedback: FeedbackModel,
        @Header("Authorization") authToken: String
    ): Response<Void>

    @GET("/game/questions/exercicios/{lessonContentId}")
    suspend fun getListExercices(
        @Path("lessonContentId") lessonContentId: UUID,
        @Header("Authorization") authToken: String
    ): Response<List<QuestionModel>>
}