package com.example.slackroid.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val SlackroidColorScheme = darkColorScheme(
    primary = PrimaryColor,
    secondary = AccentCyan,
    background = BackgroundDark,
    surface = PrimaryColor,
    onPrimary = TextWhite,
    onSecondary = Color.Black,
    onBackground = TextWhite,
    onSurface = TextWhite
)


@Composable
fun SlackroidTheme(
    useDarkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SlackroidColorScheme,
        typography = Typography,   // You can customize this next
        content = content
    )
}
