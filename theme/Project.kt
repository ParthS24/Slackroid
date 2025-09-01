package com.example.slackroid.ui.theme
import com.example.slackroid.R

data class Project(
    val id: Int,
    val title: String,
    val description: String,
    val imageResId: Int
)

object ProjectRepository {
    fun getProjects(): List<Project> {
        return listOf(
            Project(
                id = 1,
                title = "Food Delivery App",
                description = "A mobile application for food ordering and delivery.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Project(
                id = 2,
                title = "E-commerce Website",
                description = "An online store for various products.",
                imageResId = R.drawable.ic_launcher_foreground
            ),
            Project(
                id = 3,
                title = "Portfolio Website",
                description = "A personal portfolio site to showcase work.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        )
    }
}