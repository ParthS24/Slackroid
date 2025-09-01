package com.example.slackroid.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slackroid.R

@Composable
fun MarketplaceScreen(
    onOptionClick: (String) -> Unit,
    onProjectClick: (Project) -> Unit
) {
    val options: List<Pair<String, Int>> = listOf(
        "Food Projects" to R.drawable.ic_food,
        "Tech Projects" to R.drawable.ic_ecommerce,
        "Engineering Projects" to R.drawable.ic_portfolio
    )

    val projectList: List<Project> = listOf(
        Project(1, "Catering App", "A mobile app for food orders and delivery.", R.drawable.ic_food),
        Project(2, "E-commerce Platform", "A web store for gadgets.", R.drawable.ic_ecommerce),
        Project(3, "Robotics Automation", "Automation solutions for manufacturing.", R.drawable.ic_portfolio)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Marketplace",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // ✅ Neatly aligned category buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            options.forEach { (label, iconRes) ->
                OptionCard(
                    label = label,
                    iconRes = iconRes,
                    onClick = { onOptionClick(label) }
                )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(projectList) { project: Project ->
                ProjectCard(project = project, onClick = { onProjectClick(project) })
            }
        }
    }
}

@Composable
fun OptionCard(label: String, iconRes: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .clickable { onClick() }
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF1F1F1F),
            modifier = Modifier.size(80.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}
