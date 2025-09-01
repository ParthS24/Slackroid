package com.example.slackroid.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.slackroid.ui.dashboard.ChatDashboardScreen
import com.example.slackroid.ui.auth.LoginScreen
import com.example.slackroid.ui.auth.CreateAccountScreen
import com.example.slackroid.ui.careers.CareersScreen
import com.example.slackroid.ui.contact.ContactScreen
import com.example.slackroid.ui.dashboard.DashboardScreen
import com.example.slackroid.ui.theme.MarketplaceScreen
import com.example.slackroid.ui.theme.ProjectDetailScreen
import com.example.slackroid.ui.theme.SlackroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlackroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("home") { HomeScreen(navController) }
        composable("chatbot") { ChatbotScreen() }

        composable("marketplace") {
            MarketplaceScreen(
                onOptionClick = { optionName ->
                    // Handle category selection or filter navigation here
                    // Example: navController.navigate("marketplace/${optionName}")
                },
                onProjectClick = { projectId ->
                    navController.navigate("projectDetails/$projectId")
                }
            )
        }

        composable("careers") { CareersScreen() }
        composable("dashboard") { DashboardScreen(navController) }
        composable("contact") { ContactScreen() }
        composable("welcome") { WelcomeScreen(navController) }
        composable("chat_dashboard") { ChatDashboardScreen() }
        composable("login") { LoginScreen(navController) }
        composable("create_account") { CreateAccountScreen(navController) }

        composable("projectDetails/{projectId}") { backStackEntry ->
            val projectId = backStackEntry.arguments?.getString("projectId")
            ProjectDetailScreen(navController = navController, projectId = projectId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlackroidTheme {
        AppNavigation()
    }
}
