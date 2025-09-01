package com.example.slackroid.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slackroid.R
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {
    var showLogo by remember { mutableStateOf(false) }
    var showTitle by remember { mutableStateOf(false) }
    var showButtons by remember { mutableStateOf(false) }

    // Staggered animations trigger
    LaunchedEffect(Unit) {
        showLogo = true
        delay(300)
        showTitle = true
        delay(300)
        showButtons = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF121212), Color(0xFF1E1E1E))
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            // Logo with fade
            AnimatedVisibility(
                visible = showLogo,
                enter = fadeIn(animationSpec = tween(800)),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF1A1A1A))
                        .shadow(12.dp, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.slackroid_logo),
                        contentDescription = "Slackroid Bot",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(200.dp)
                    )
                }
            }

            // Title & tagline with fade
            AnimatedVisibility(
                visible = showTitle,
                enter = fadeIn(animationSpec = tween(800)),
                exit = fadeOut()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)) {
                                append("Slackroid - ")
                            }
                            withStyle(style = SpanStyle(color = Color(0xFFBB86FC), fontSize = 28.sp, fontWeight = FontWeight.Bold)) {
                                append("Your AI")
                            }
                        }
                    )
                    Text(
                        text = "Language Partner",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFBB86FC)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Unlock infinite conversations,\nYour AI Companion",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(top = 8.dp),
                    )
                }
            }

            // Buttons with fade
            AnimatedVisibility(
                visible = showButtons,
                enter = fadeIn(animationSpec = tween(800)),
                exit = fadeOut()
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Button(
                        onClick = { navController.navigate("login") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC))
                    ) {
                        Text("Log In", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = { navController.navigate("create_account") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = ButtonDefaults.outlinedButtonBorder.copy(
                            width = 1.dp,
                            brush = Brush.horizontalGradient(listOf(Color(0xFFBB86FC), Color.Cyan))
                        )
                    ) {
                        Text("Create Account", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
