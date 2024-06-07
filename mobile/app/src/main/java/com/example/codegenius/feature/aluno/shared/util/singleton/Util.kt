package com.example.codegenius.feature.aluno.shared.util.singleton

import com.example.codegenius.feature.aluno.course.model.DataUserModel
import com.example.codegenius.feature.aluno.login.models.Token
import java.util.UUID

class Util {

    lateinit var authToken: Token
    lateinit var email: String
    lateinit var dataUser: DataUserModel
    lateinit var  courseId: UUID;

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