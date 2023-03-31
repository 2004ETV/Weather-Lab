package com.weather.compose.sample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.weather.compose.core.R

val vkSans = FontFamily(
    Font(R.font.vk_sans_regular, FontWeight.Normal),
    Font(R.font.vk_sans_medium, FontWeight.Medium),
    Font(R.font.vk_sans_demibold, FontWeight.SemiBold),
    Font(R.font.vk_sans_bold, FontWeight.Bold),
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = vkSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = -(0.33).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = vkSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = -(0.33).sp
    ),
    titleMedium = TextStyle(
        fontFamily = vkSans,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 24.sp,
        letterSpacing = -(0.33).sp
    ),
    titleLarge = TextStyle(
        fontFamily = vkSans,
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp,
        lineHeight = 24.sp,
        letterSpacing = -(0.33).sp
    )
)