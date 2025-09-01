package com.example.slackroid.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slackroid.R


@Composable
fun ChatDashboardScreen() {
    val recentChats = listOf(
        "Best UI design tips",
        "AI tools for startups",
        "Generate marketing copy",
        "Build a weather app with Compose"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.slackroid_logo), // your app logo
                contentDescription = "Profile",
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text("Good Morning 👋", fontWeight = FontWeight.SemiBold)
                Text("Zachary Williamson", fontSize = 14.sp, color = Color.Gray)
            }
        }

        Spacer(Modifier.height(20.dp))

        // Search Field
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search for prompts") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.History, contentDescription = null)
            }
        )

        Spacer(Modifier.height(20.dp))

        Text("Recent Chats", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(Modifier.height(12.dp))

        // Scrollable Recent Prompts
        LazyColumn {
            items(recentChats) { prompt ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { /* Navigate to chat */ },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = prompt,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
