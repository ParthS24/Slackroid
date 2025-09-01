package com.example.slackroid.ui.home

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults // Crucial for ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CTAButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue), // Example color
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier // Add modifier to allow external customization
    ) {
        Text(text = text, color = Color.White)
    }
}