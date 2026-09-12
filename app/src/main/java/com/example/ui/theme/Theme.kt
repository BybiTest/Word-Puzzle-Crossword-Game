package com.example.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// 1. تعریف ساختار داده‌ای تم
data class GameThemeData(
    val id: String,
    val name: String,
    val primary: Color = Color(0xFF6200EE),
    val primaryVariant: Color = Color(0xFF3700B3),
    val accent: Color = Color(0xFF03DAC6),
    val textColor: Color = Color(0xFF121212),
    val textSecondary: Color = Color(0xFF757575),
    val cardBackground: Color = Color(0xFFFFFFFF),
    val cardBorder: Color = Color(0xFFE0E0E0),
    val letterWheelCenter: Color = Color(0xFFFF9800),
    val backgroundGradient: Brush = Brush.linearGradient(listOf(Color(0xFFF5F5F5), Color(0xFFE0E0E0))),
    val letterButtonGradient: Brush = Brush.linearGradient(listOf(Color(0xFFE0E0E0), Color(0xFFBDBDBD)))
)

// 2. تعریف تم‌های موجود
object GameThemes {
    val turquoise = GameThemeData(
        id = "turquoise",
        name = "فیروزه‌ای",
        primary = Color(0xFF009688),
        primaryVariant = Color(0xFF004D40),
        accent = Color(0xFFFFC107),
        textColor = Color(0xFF121212),
        textSecondary = Color(0xFF757575),
        cardBackground = Color(0xFFFFFFFF),
        cardBorder = Color(0xFFB2DFDB),
        letterWheelCenter = Color(0xFF004D40),
        backgroundGradient = Brush.linearGradient(listOf(Color(0xFFE0F2F1), Color(0xFFB2DFDB))),
        letterButtonGradient = Brush.linearGradient(listOf(Color(0xFF4DB6AC), Color(0xFF009688)))
    )

    fun getThemeById(id: String): GameThemeData {
        return when (id) {
            "turquoise" -> turquoise
            else -> turquoise
        }
    }
}

// 3. این خط جادویی است: به کامپایلر می‌گوید GameTheme همان GameThemeData است
typealias GameTheme = GameThemeData
