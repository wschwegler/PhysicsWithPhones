package com.example.llnlphysicsengine_android_jetcompose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = DarkGrey,
    onPrimary = White,
    secondary = Grey,
    background = Black,
    onBackground = Grey

)

private val LightColorScheme = lightColorScheme(
    primary = White,
    onPrimary = Black,
    secondary = Black,
    background = LightGrey,
    onBackground = Black
)

@Composable
fun LLNLPhysicsEngineAndroidJetComposeTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {

    MaterialTheme(
        colorScheme = if(darkTheme) DarkColorScheme else LightColorScheme,
        typography = MyTypography,
        content = content
    )
}