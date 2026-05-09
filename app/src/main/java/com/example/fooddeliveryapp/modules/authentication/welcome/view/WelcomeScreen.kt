package com.example.fooddeliveryapp.modules.authentication.welcome.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.R

@Composable
fun WelcomeScreen() {
    // Figma jesa Light Orange aur White ka Gradient background
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFE082), // Light Orange top
            Color(0xFFF5F5F5)  // Near-white bottom
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // 1. Heading Text
            Text(
                text = "the best food\ndelivery service",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
                textAlign = TextAlign.Center,
                lineHeight = 38.sp,
                modifier = Modifier.padding(top = 40.dp)
            )

            // 2. Center Image (Delivery Boy)
            Image(
                // Extension (.jpg ya .png) likhne ki zaroorat nahi hoti
                painter = painterResource(id = R.drawable.delivery_boy),
                contentDescription = "Delivery Boy",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                contentScale = ContentScale.Fit
            )

            // 3. Buttons Area
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                WelcomeButton(text = "Log In")
                WelcomeButton(text = "Sign Up")
            }
        }
    }
}

@Composable
fun WelcomeButton(text: String) {
    Button(
        onClick = { /* Navigation yahan add karen */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFB800) // Figma Orange Color
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            // Arrow Icon jesa Figma mein hai
            Text(
                text = "→",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}