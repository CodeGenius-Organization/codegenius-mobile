package com.example.codegenius.feature.aluno.network

import com.example.codegenius.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig{

   fun getInstance(): Retrofit {
      return Retrofit
         .Builder()
         .baseUrl(BuildConfig.BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
   }

}