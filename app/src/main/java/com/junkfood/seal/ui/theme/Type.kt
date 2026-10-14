package com.junkfood.seal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp

/**
 * Editorial pairing: a serif for headings and a clean sans for UI text.
 *
 * Target fonts are Fraunces (display) and Instrument Sans (body). Until the .ttf files are added to
 * res/font and wired here, the system serif/sans families are used as fallbacks.
 */
object SealFonts {
    val Display: FontFamily = FontFamily.Serif
    val Body: FontFamily = FontFamily.SansSerif
}

private fun display(size: Int, line: Int, spacing: Double = 0.0) =
    TextStyle(
        fontFamily = SealFonts.Display,
        fontWeight = FontWeight.Normal,
        fontSize = size.sp,
        lineHeight = line.sp,
        letterSpacing = spacing.sp,
        textDirection = TextDirection.Content,
    )

val Typography =
    Typography().run {
        copy(
            displayLarge = displayLarge.applyTextDirection().copy(fontFamily = SealFonts.Display),
            displayMedium = displayMedium.applyTextDirection().copy(fontFamily = SealFonts.Display),
            displaySmall = displaySmall.applyTextDirection().copy(fontFamily = SealFonts.Display),
            headlineLarge = display(32, 36, -0.3),
            headlineMedium = display(28, 32, -0.2),
            headlineSmall = display(24, 28),
            titleLarge = display(22, 28),
            titleMedium = titleMedium.body(),
            titleSmall = titleSmall.body(),
            bodyLarge = bodyLarge.applyLinebreak().body(),
            bodyMedium = bodyMedium.applyLinebreak().body(),
            bodySmall = bodySmall.applyLinebreak().body(),
            labelLarge = labelLarge.body(),
            labelMedium = labelMedium.body(),
            labelSmall = labelSmall.body(),
        )
    }

private fun TextStyle.body(): TextStyle = applyTextDirection().copy(fontFamily = SealFonts.Body)

private fun TextStyle.applyLinebreak(): TextStyle = this.copy(lineBreak = LineBreak.Paragraph)

private fun TextStyle.applyTextDirection(): TextStyle =
    this.copy(textDirection = TextDirection.Content)
