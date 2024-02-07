package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Найдите ваш CustomView по ID
        val customSocialPostView = findViewById<SocialPostView>(R.id.customSocialPostView)

        // Установите желаемый текст с помощью методов, которые вы определили в SocialPostView
//        customSocialPostView.setTopText("Верхняя строка")
//        customSocialPostView.setBottomText("Нижняя строка")
    }
}

