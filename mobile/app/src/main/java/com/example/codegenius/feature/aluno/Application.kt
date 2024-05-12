package com.example.codegenius.feature.aluno

import android.app.Application
import android.os.Build
import androidx.core.content.ContextCompat
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.network.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(appModule)
        }
    }
}