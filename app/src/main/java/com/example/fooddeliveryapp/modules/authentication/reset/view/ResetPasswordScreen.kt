package com.example.fooddeliveryapp.modules.authentication.reset.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.modules.authentication.reset.viewmodel.ResetPasswordViewModel
import com.example.fooddeliveryapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel = viewModel()
) {
    val newPassword by viewModel.newPassword
    val confirmPassword by viewModel.confirmPassword

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BackgroundGradientStart, BackgroundGradientEnd)))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Scooter Image (delivery_boy)
            Image(
                painter = painterResource(id = R.drawable.delivery_boy),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = CardShape,
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Reset Password", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)

                    Spacer(modifier = Modifier.height(30.dp))

                    // Field 1: New Password
                    TextField(
                        value = newPassword,
                        onValueChange = { viewModel.onNewPasswordChange(it) },
                        placeholder = { Text("New password") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = ComponentShape,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = InputFieldBackground,
                            unfocusedContainerColor = InputFieldBackground,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    // Field 2: Confirm Password
                    TextField(
                        value = confirmPassword,
                        onValueChange = { viewModel.onConfirmPasswordChange(it) },
                        placeholder = { Text("Confirm password") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = ComponentShape,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = InputFieldBackground,
                            unfocusedContainerColor = InputFieldBackground,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // Continue Button
                    Button(
                        onClick = { viewModel.updatePassword() },
                        modifier = Modifier.fillMaxWidth().height(55.dp),
                        shape = ComponentShape,
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
                    ) {
                        Text("Continue", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                }
            }
        }
    }
}
