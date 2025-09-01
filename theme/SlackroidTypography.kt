package com.example.slackroid.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.slackroid.R
import androidx.compose.ui.text.googlefonts.Font


// Define the Google Font provider
private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Specify the Google font you want to use
private val poppins = GoogleFont("Poppins")

// Create a FontFamily using the Google font and provider
val PoppinsFontFamily = FontFamily(
    Font(googleFont = poppins, fontProvider = provider)


)

// Set up the Typography using your font family
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontSize = 26.sp
    ),
    titleMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontSize = 16.sp
    )
    // Add more styles if needed
)
