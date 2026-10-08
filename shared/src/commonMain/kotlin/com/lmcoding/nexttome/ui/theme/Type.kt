package com.lmcoding.nexttome.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import nexttome.shared.generated.resources.Res
import nexttome.shared.generated.resources.Roboto_Bold
import nexttome.shared.generated.resources.Roboto_Medium
import nexttome.shared.generated.resources.Roboto_Regular
import org.jetbrains.compose.resources.Font

@Composable
fun bodyFontFamily() = FontFamily(
    Font(Res.font.Roboto_Regular, FontWeight.Normal),
    Font(Res.font.Roboto_Medium, FontWeight.Medium),
    Font(Res.font.Roboto_Bold, FontWeight.Bold),
)

@Composable
fun displayFontFamily() = bodyFontFamily()

@Composable
fun appTypography(): Typography {
    val body = bodyFontFamily()
    val display = displayFontFamily()
    val baseline = Typography()

    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = display),
        displayMedium = baseline.displayMedium.copy(fontFamily = display),
        displaySmall = baseline.displaySmall.copy(fontFamily = display),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = display),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = display),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = display),
        titleLarge = baseline.titleLarge.copy(fontFamily = display),
        titleMedium = baseline.titleMedium.copy(fontFamily = display),
        titleSmall = baseline.titleSmall.copy(fontFamily = display),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = body),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = body),
        bodySmall = baseline.bodySmall.copy(fontFamily = body),
        labelLarge = baseline.labelLarge.copy(fontFamily = body),
        labelMedium = baseline.labelMedium.copy(fontFamily = body),
        labelSmall = baseline.labelSmall.copy(fontFamily = body),
    )
}
