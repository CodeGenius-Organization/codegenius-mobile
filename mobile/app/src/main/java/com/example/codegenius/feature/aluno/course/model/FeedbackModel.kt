package com.example.codegenius.feature.aluno.course.model

import java.util.UUID

data class FeedbackModel(
   val userFk: UUID,
   val moduleFk: UUID,
   val stars: Int,
   val feedback: String,
   val feedbackDate: String,
)
