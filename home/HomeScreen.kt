package com.example.slackroid.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slackroid.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var showContent by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }

    // Feature list
    val features = listOf(
        FeatureItem("Explore Projects", "Browse pre-built applications you can buy or customize.", Icons.Default.GridView, "marketplace"),
        FeatureItem("Meet SlackBot", "Our AI assistant helps collect project requirements.", Icons.Default.SmartToy, "chatbot"),
        FeatureItem("Start Your Career", "Apply for internships or full-time tech roles.", Icons.Default.Work, "careers"),
        FeatureItem("Contact Us", "Get in touch with our team or schedule a consultation.", Icons.Default.Phone, "contact"),
        FeatureItem("Dashboard", "View your active projects and progress.", Icons.Default.Dashboard, "dashboard")
    )

    // Filtered list
    val filteredFeatures = features.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.description.contains(searchQuery, ignoreCase = true)
    }

    // Delayed animation for content
    LaunchedEffect(Unit) {
        delay(300)
        showContent = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Top Banner
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ai_banner), // Replace with your drawable
                contentDescription = "AI Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Title
        Text(
            "Welcome to Slackroid",
            fontSize = 26.sp,
            color = Color(0xFFBB86FC),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Build. Launch. Automate.\nEverything you need to launch your next software project — powered by AI.",
            color = Color(0xFFB0B0B0),
            fontSize = 16.sp,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search features...", color = Color.Gray) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
            },
            singleLine = true,
            shape = RoundedCornerShape(50),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color(0xFF1E1E1E),
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.White,
                cursorColor = Color.White
            )
            ,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Animated Feature List
        AnimatedVisibility(visible = showContent) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                filteredFeatures.forEach { feature ->
                    HomeFeatureCard(
                        title = feature.title,
                        description = feature.description,
                        icon = {
                            Icon(
                                feature.icon,
                                contentDescription = null,
                                tint = Color(0xFFBB86FC)
                            )
                        }
                    ) { navController.navigate(feature.route) }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeFeatureCard(
    title: String,
    description: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon()
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    description,
                    color = Color(0xFFB0B0B0),
                    fontSize = 14.sp
                )
            }
        }
    }
}

data class FeatureItem(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val route: String
)
