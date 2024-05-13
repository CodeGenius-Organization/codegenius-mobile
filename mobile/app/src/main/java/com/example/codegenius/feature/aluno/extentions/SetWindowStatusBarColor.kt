package com.example.codegenius.feature.aluno.extentions

import android.app.Activity
import android.os.Build
import androidx.core.content.ContextCompat
import com.example.codegenius.R

fun Activity.setWindowStatusBarColor() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.blue_daken)
    }
}