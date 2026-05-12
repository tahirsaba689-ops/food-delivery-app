package com.example.fooddeliveryapp.modules.authentication.forget.view

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
import com.example.fooddeliveryapp.modules.authentication.forget.viewmodel.ForgetPasswordViewModel
import com.example.fooddeliveryapp.ui.theme.*
import com.example.fooddeliveryapp.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetPasswordScreen(
    viewModel: ForgetPasswordViewModel = viewModel(),
    onContinueClick: () -> Unit // Yeh parameter add karein
){
    // .value use karein ya 'by' delegate use karein
    val emailState = viewModel.email.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BackgroundGradientStart, BackgroundGradientEnd)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Scooter Image
            // Scooter Image
            Image(
                painter = painterResource(id = R.drawable.delivery_boy), // 'android.R' ki bajaye sirf 'R' use karein
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = CardShape,
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Forget Password",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "please enter your email\nto reset password",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    TextField(
                        value = emailState,
                        onValueChange = { viewModel.onEmailChange(it) },
                        placeholder = { Text("Enter your email") },
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

                    Button(
                        // Line 99 ko is tarah badlein:
                        onClick = {
                            viewModel.sendResetLink()
                            onContinueClick() // Yeh agli screen (Reset Password) par le jayega
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = ComponentShape,
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
                    ) {
                        Text(
                            text = "Continue",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}