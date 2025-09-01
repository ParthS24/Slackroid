package com.example.slackroid.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import com.example.slackroid.R


@Composable
fun DashboardScreen(navController: NavController) {
    val projectStatus = listOf(
        Triple("E-Commerce App", "UI Done, Backend 70%", "Invoice.pdf"),
        Triple("Portfolio Site", "Complete", "Invoice2.pdf")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            "Client Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBB86FC)
        )

        Spacer(modifier = Modifier.height(24.dp))

        projectStatus.forEach {
            ProjectStatusCard(
                project = it.first,
                status = it.second,
                invoice = it.third
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                // Trigger WhatsApp/Email intent
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBB86FC))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_whatsapp),
                contentDescription = "WhatsApp",
                tint = Color.Unspecified, // Keeps original icon color
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text("Contact Assigned Team", color = Color.Black)
        }
    }
}