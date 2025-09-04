package com.echosystem.echosystemapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BlueLight,
    secondary = GreenVibrant,
    tertiary = BlueGray,
    background = BlueDark,
    surface = BlueDark,
    onPrimary = WhiteIce,
    onSecondary = Black,
    onTertiary = WhiteIce,
    onBackground = WhiteIce,
    onSurface = WhiteIce
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = GreenLight,
    tertiary = BlueLight,
    background = WhiteIce,
    surface = WhiteIce,
    onPrimary = WhiteIce,
    onSecondary = Black,
    onTertiary = WhiteIce,
    onBackground = BlueDark,
    onSurface = BlueDark
)

@Composable
fun EchosystemappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}