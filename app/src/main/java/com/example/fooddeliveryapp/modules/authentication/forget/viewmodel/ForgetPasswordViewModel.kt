package com.example.fooddeliveryapp.modules.authentication.forget.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordViewModel : ViewModel() {

    // Email state jo UI (TextField) ke saath connect hogi
    var email: MutableState<String> = mutableStateOf("")

    // Firebase Auth ka instance
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Jab user TextField mein kuch likhega toh ye function call hoga
    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    // "Continue" button click hone par ye function call hoga
    fun sendResetLink() {
        val emailValue = email.value

        if (emailValue.isNotEmpty()) {
            auth.sendPasswordResetEmail(emailValue)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Success: Password reset email bhej di gayi hai
                        println("Reset link sent successfully to $emailValue")
                    } else {
                        // Error: Jaise ke galat email ya network issue
                        println("Error: ${task.exception?.message}")
                    }
                }
        }
    }
}
