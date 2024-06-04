package com.example.codegenius.feature.aluno.course.repositories

import com.example.codegenius.feature.aluno.course.model.CourseDetailModule
import com.example.codegenius.feature.aluno.course.model.FeedbackModel
import com.example.codegenius.feature.aluno.course.model.HeartModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.model.ResultTestModel
import retrofit2.Response
import java.util.UUID

interface ICourseDetailRepository {
    suspend fun getHeart(userId: UUID): Response<HeartModel>
    suspend fun patchHeart(userId: UUID, heart: Int): Response<HeartModel>
    suspend fun getCourse(courseId: UUID): Response<CourseDetailModule>
    suspend fun postResultTest(resultExam: ResultTestModel): Response<Void>
    suspend fun postFeedback(feedback: FeedbackModel): Response<Void>
    suspend fun getListExercices(lessonContentId: UUID): Response<List<QuestionModel>>
}