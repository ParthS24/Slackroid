package com.example.slackroid.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ChatbotScreen() {
    val messages = remember {
        mutableStateListOf(
            "Hello! How can I help you today?",
            "I need help with my project.",
            "Okay, I see. What kind of project is it?"
        )
    }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var userInput by remember { mutableStateOf("") }

    // Auto-scroll to last message
    LaunchedEffect(messages.size) {
        listState.animateScrollToItem(messages.size - 1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(12.dp)
    ) {
        // Header
        Text(
            text = "SlackBot 🤖",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Chat messages
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { message ->
                AnimatedVisibility(visible = true, enter = fadeIn()) {
                    ChatBubble(
                        text = message,
                        isBot = messages.indexOf(message) % 2 == 0
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Input Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFF1E1E1E))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                placeholder = { Text("Ask me anything...", color = Color.LightGray) },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFBB86FC),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            IconButton(
                onClick = {
                    if (userInput.isNotBlank()) {
                        messages.add(userInput)
                        userInput = ""

                        coroutineScope.launch {
                            delay(500)
                            messages.add("SlackBot is typing...")
                            delay(1000)
                            messages.removeAt(messages.lastIndex)
                            messages.add("SlackBot: Got it! Let me help you with that.")
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = Color(0xFFBB86FC)
                )
            }
        }
    }
}

