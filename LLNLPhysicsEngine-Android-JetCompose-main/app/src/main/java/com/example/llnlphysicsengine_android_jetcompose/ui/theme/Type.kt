package com.example.llnlphysicsengine_android_jetcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.llnlphysicsengine_android_jetcompose.R

val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_bold, weight = FontWeight.Bold),
    Font(R.font.sf_pro_display_medium, weight = FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, weight = FontWeight.Normal),
    Font(R.font.sf_pro_display_light, weight = FontWeight.Light)
)


val MyTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 37.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Thin,
        fontSize = 15.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
)