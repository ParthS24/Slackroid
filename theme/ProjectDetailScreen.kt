package com.example.slackroid.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState


@Composable
fun ProjectDetailScreen(navController: NavController, projectId: String?) {
    val project = ProjectRepository.getProjects().find { it.id == projectId?.toIntOrNull()} ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // 🔙 Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text(
                text = "Project Details",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // 🧾 Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            // 🖼 Cover Image
            Image(
                painter = painterResource(id = project.imageResId),
                contentDescription = project.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🏷 Title
            Text(
                text = project.title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 💰 Price (Optional hardcoded for now)
            Text(
                text = "₹3999 | 1-week delivery",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🧩 Tags (You can update this to be dynamic if you want)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TagChip("Jetpack Compose")
                TagChip("Firebase")
                TagChip("Dark Theme")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 📄 Description
            Text(
                text = project.description,
                fontSize = 16.sp,
                color = Color.LightGray,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            // 💬 CTA Button
            Button(
                onClick = { /* Handle purchase */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC))
            ) {
                Text("Get This Project", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
@Composable
fun TagChip(tag: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = Color(0xFF2C2C2C),
        tonalElevation = 2.dp
    ) {
        Text(
            text = tag,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

