package com.example.fooddeliveryapp.modules.authentication.reset.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ResetPasswordViewModel : ViewModel() {
    // Do alag states naye passwords ke liye
    var newPassword = mutableStateOf("")
    var confirmPassword = mutableStateOf("")

    fun onNewPasswordChange(value: String) {
        newPassword.value = value
    }

    fun onConfirmPasswordChange(value: String) {
        confirmPassword.value = value
    }

    fun updatePassword() {
        if (newPassword.value == confirmPassword.value) {
            // Firebase update logic yahan aayegi
            println("Password Reset Successful")
        } else {
            println("Passwords do not match")
        }
    }
}