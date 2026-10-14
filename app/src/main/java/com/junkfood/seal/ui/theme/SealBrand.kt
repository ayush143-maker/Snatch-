package com.junkfood.seal.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/** Seal brand palette: off-white paper, ink black, and the cyan to blue gradient from the logo. */
object SealBrand {
    val OffWhite = Color(0xFFF5F3EE)
    val Ink = Color(0xFF0B0B0C)
    val Cyan = Color(0xFF01CDFD)
    val Blue = Color(0xFF2638FA)
    val Hairline = Color(0xFFDDDAD2)
    val Muted = Color(0xFF6B6B66)

    /** Use only for progress, active indicators and primary accents. */
    val Gradient = Brush.horizontalGradient(listOf(Cyan, Blue))
}

val SealBrandLightColorScheme =
    lightColorScheme(
        primary = SealBrand.Ink,
        onPrimary = SealBrand.OffWhite,
        primaryContainer = Color(0xFFD9ECFF),
        onPrimaryContainer = SealBrand.Ink,
        secondary = SealBrand.Blue,
        onSecondary = Color.White,
        secondaryContainer = Color(0xFFE7E3D9),
        onSecondaryContainer = SealBrand.Ink,
        tertiary = Color(0xFF0A6FD8),
        onTertiary = Color.White,
        tertiaryContainer = Color(0xFFD6F5FF),
        onTertiaryContainer = SealBrand.Ink,
        background = SealBrand.OffWhite,
        onBackground = SealBrand.Ink,
        surface = SealBrand.OffWhite,
        onSurface = SealBrand.Ink,
        surfaceVariant = Color(0xFFECE9E0),
        onSurfaceVariant = SealBrand.Muted,
        surfaceTint = SealBrand.OffWhite,
        inverseSurface = SealBrand.Ink,
        inverseOnSurface = SealBrand.OffWhite,
        inversePrimary = SealBrand.Cyan,
        outline = Color(0xFF8A8A84),
        outlineVariant = SealBrand.Hairline,
        surfaceDim = Color(0xFFE2DED3),
        surfaceBright = SealBrand.OffWhite,
        surfaceContainerLowest = Color(0xFFFBFAF7),
        surfaceContainerLow = Color(0xFFF0EDE5),
        surfaceContainer = Color(0xFFECE9E0),
        surfaceContainerHigh = Color(0xFFE7E3D9),
        surfaceContainerHighest = Color(0xFFE2DED3),
        error = Color(0xFFB3261E),
        onError = Color.White,
        errorContainer = Color(0xFFF9DEDC),
        onErrorContainer = Color(0xFF410E0B),
    )
