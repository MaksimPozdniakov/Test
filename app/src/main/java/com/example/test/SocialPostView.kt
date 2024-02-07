package com.example.test

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class SocialPostView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        val padding = dpToPx(15)

        // Создание первого контейнера
        val firstContainer = LinearLayout(context).apply {
            id = generateViewId() // генерация уникального идентификатора
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.HORIZONTAL
            setPadding(padding, padding, padding, padding)
        }

        // Создание изображения внутри первого контейнера
        val profileImageView = ImageView(context).apply {
            layoutParams = LayoutParams(dpToPx(150), dpToPx(150))
            setBackgroundColor(Color.BLACK) // временный цвет для тестирования
        }
        firstContainer.addView(profileImageView)

        // Создание второго контейнера внутри первого контейнера
        val textContainer = LinearLayout(context).apply {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.VERTICAL
            setPadding(padding, 0, 0, 0) // отступ слева для второго контейнера
        }

        // Создание текстовых элементов внутри второго контейнера
        val topTextView = TextView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            text = "Верхняя строка"
            setTextColor(Color.BLACK)
        }
        textContainer.addView(topTextView)

        val bottomTextView = TextView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            text = "Нижняя строка"
            setTextColor(Color.BLACK)
            setPadding(0, dpToPx(25), 0, 0) // отступ сверху для второго текстового элемента
        }
        textContainer.addView(bottomTextView)

        firstContainer.addView(textContainer)
        addView(firstContainer)

        // Создание второго контейнера (под первым контейнером)
        val secondContainer = LinearLayout(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setPadding(padding, 0, padding, padding) // отступ снизу для второго контейнера
        }

        // Создание изображения внутри второго контейнера
        val contentImageView = ImageView(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setBackgroundColor(Color.GRAY) // временный цвет для тестирования
        }
        secondContainer.addView(contentImageView)

        val secondContainerParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        secondContainerParams.addRule(BELOW, firstContainer.id) // размещение второго контейнера под первым контейнером
        secondContainer.layoutParams = secondContainerParams

        addView(secondContainer)
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}
