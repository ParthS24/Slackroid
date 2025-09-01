package com.example.slackroid.ui.careers

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CareersScreen() {
    val jobList = listOf(
        "Android Developer Intern",
        "React Developer Intern",
        "UI/UX Designer Intern"
    )

    var selectedJob by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Careers & Internships",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color(0xFF00E676) // Vibrant green accent
        )

        Spacer(modifier = Modifier.height(20.dp))

        jobList.forEach { job ->
            JobCard(
                title = job,
                onClick = { selectedJob = job }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        if (selectedJob.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            ApplicationForm(jobTitle = selectedJob)
        }
    }
}

