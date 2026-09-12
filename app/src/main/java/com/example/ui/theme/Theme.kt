package com.example.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ====================================================================
// تعریف تمام رنگ‌ها و تم‌هایی که در لاگ خطا داده شده‌اند
// ====================================================================

// 1. رنگ‌های پایه (برای دسترسی مستقیم در تمام فایل‌ها)
val primary = Color(0xFF6200EE)
val secondary = Color(0xFF03DAC6)
val primaryVariant = Color(0xFF3700B3)
val accent = Color(0xFF03DAC6)
val textColor = Color(0xFF121212)
val textSecondary = Color(0xFF757575)
val cardBackground = Color(0xFFFFFFFF)
val cardBorder = Color(0xFFE0E0E0)
val letterWheelCenter = Color(0xFFFF9800)

// 2. کلاس داده برای نگهداری مشخصات هر تم 
// (نکته: گرادیانت‌ها به صورت Brush تعریف شده‌اند تا خطای Ambiguity رفع شود)
data class GameThemeData(
    val id: String,
    val name: String,
    val primary: Color = primary,
    val secondary: Color = secondary,
    val primaryVariant: Color = primaryVariant,
    val accent: Color = accent,
    val textColor: Color = textColor,
    val textSecondary: Color = textSecondary,
    val cardBackground: Color = cardBackground,
    val cardBorder: Color = cardBorder,
    val letterWheelCenter: Color = letterWheelCenter,
    val backgroundGradient: Brush = Brush.linearGradient(listOf(Color(0xFFF5F5F5), Color(0xFFE0E0E0))),
    val letterButtonGradient: Brush = Brush.linearGradient(listOf(Color(0xFFE0E0E0), Color(0xFFBDBDBD)))
)

// 3. شیء اصلی مدیریت تم‌ها
object GameThemes {
    val turquoise = GameThemeData(
        id = "turquoise",
        name = "فیروزه‌ای",
        primary = Color(0xFF009688),
        secondary = Color(0xFF00796B),
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
            else -> turquoise // تم پیش‌فرض
        }
    }
}

// 4. رفع خطای فایل‌هایی که به اشتباه به جای GameThemes، نوشته‌اند GameTheme
val GameTheme = GameThemes
