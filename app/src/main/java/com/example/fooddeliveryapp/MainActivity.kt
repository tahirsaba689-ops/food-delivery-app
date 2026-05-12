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
import com.example.fooddeliveryapp.modules.authentication.forget.view.ForgetPasswordScreen
import com.example.fooddeliveryapp.modules.authentication.reset.view.ResetPasswordScreen

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
        startDestination = "welcome" // Ya jo bhi aapki pehli screen hai
    ) {
        composable(route = "welcome") {
            WelcomeScreen(
                onLoginClick = { navController.navigate("login") },
                onSignupClick = { navController.navigate("signup") }
            )
        }

        composable(route = "login") {
            LoginScreen(
                onSignUpClick = { navController.navigate("signup") },
                // Yahan Forget Password ka click handle karein
                onForgetPasswordClick = { navController.navigate("forget") }
            )
        }

        composable(route = "signup") {
            SignupScreen(
                onLoginClick = { navController.navigate("login") }
            )
        }

        // Line 79: Forget Password ka route yahan shuru hota hai
        composable(route = "forget") {
            ForgetPasswordScreen(
                onContinueClick = { navController.navigate("reset_password") }
            )
        } // <--- Yeh bracket line 81 par khatam ho raha hai

        // YAHAN LIKHEIN (Line 82 par purana code delete karke ye naya likhein)
        composable(route = "reset_password") {
            ResetPasswordScreen()
        }

            }
        }