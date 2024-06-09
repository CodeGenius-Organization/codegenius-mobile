package com.example.codegenius.feature.aluno.shared.util.singleton

import com.example.codegenius.feature.aluno.course.model.DataUserModel
import com.example.codegenius.feature.aluno.course.model.LessonContentModel
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.login.models.Token
import java.util.UUID

class Util {

    lateinit var authToken: Token
    lateinit var email: String
    lateinit var dataUser: DataUserModel
    lateinit var courseId: UUID;
    lateinit var modules: Set<ModuleModel>
    lateinit var lessonContent: LessonContentModel
    lateinit var listExercices: List<QuestionModel>

    companion object{
        private val instance = Util()
        fun getInstance(): Util {
            return instance
        }
    }

    fun clearToken(){
        authToken = Token("")
    }
}