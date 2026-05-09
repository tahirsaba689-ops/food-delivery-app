package com.example.fooddeliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddeliveryapp.modules.authentication.login.view.LoginScreen
import com.example.fooddeliveryapp.modules.authentication.signup.view.SignupScreen
import com.example.fooddeliveryapp.modules.authentication.welcome.view.WelcomeScreen
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            // Line 21 ko aise badlein:
            setContent {
                FoodDeliveryAppTheme {
                    AppNavigation()
                }
            }

                }
            }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryAppTheme {
        Greeting("Android")
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable(route = "welcome") {
            WelcomeScreen(
                onLoginClick = { navController.navigate(route = "login") },
                onSignupClick = { navController.navigate(route = "signup") }
            )
        }

        composable(route = "login") {
            LoginScreen(
                onSignUpClick = { navController.navigate(route = "signup") }
            )
        }

        composable(route = "signup") {
            SignupScreen(
                onLoginClick = { navController.navigate(route = "login") }
            )
        }
    }
}