package com.example.fooddeliveryapp.modules.authentication.signup.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.R // Apna package name check kar lein

@Composable
fun SignupScreen (
            onLoginClick: () -> Unit,
             onSignupSuccess: () -> Unit
)
{ // Ye bracket ke andar wala hissa add karein {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFE5B4), Color(0xFFFFD180))
                )
            )
    ) {
        // --- Top Images Section ---
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Delivery Boy Image
            Image(
                painter = painterResource(id = R.drawable.delivery_boy),
                contentDescription = "Delivery Boy",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Fit
            )
        }

        // --- Signup Card ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp) // Side spaces
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp), // Screen ke bilkul neechay se thoda ooper
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFE5B4).copy(alpha = 0.9f) // Light Yellowish background
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Input Fields
                CustomTextField(placeholder = "name")
                CustomTextField(placeholder = "last name")
                CustomTextField(placeholder = "email")
                CustomTextField(placeholder = "password")
                CustomTextField(placeholder = "number")

                Spacer(modifier = Modifier.height(20.dp))

                // Create Account Button
                Button(
                    onClick = { onSignupSuccess() },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Create Account", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Google Sign Up
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Sign up with Google", fontSize = 14.sp)
                }

                // Jahan "Log in" wala option hai:
                TextButton(onClick = { onLoginClick() }) { // Ye call karega Login screen ko
                    Text(
                        text = "already register? Log in",
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(placeholder: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(text = placeholder, fontSize = 14.sp)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        // Error Fix: Material3 mein 'colors' ka naya tarika
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFFD580).copy(alpha = 0.5f),
            unfocusedContainerColor = Color(0xFFFFD580).copy(alpha = 0.5f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)
    )
}