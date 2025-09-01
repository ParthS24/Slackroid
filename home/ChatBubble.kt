package com.example.slackroid.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
@Composable
fun ChatBubble(text: String, isBot: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = if (isBot) Arrangement.Start else Arrangement.End
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = if (isBot) Color(0xFF2E2E2E) else Color(0xFFBB86FC),
            tonalElevation = 2.dp,
        ) {
            Text(
                text = text,
                color = if (isBot) Color.White else Color.Black,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
