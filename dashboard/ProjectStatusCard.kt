package com.example.slackroid.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


@Composable
fun ProjectStatusCard(
    project: String,
    status: String,
    invoice: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1F1F)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = project, color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = status, color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Invoice: $invoice", color = Color.LightGray, fontSize = 12.sp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProjectStatusCardPreview() {
    ProjectStatusCard(
        project = "Backend Integration",
        status = "Completed 65%",
        invoice = "Invoice_Backend.pdf"
    )
}