package com.banking.wallet.user.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserRequest(

    @field:NotBlank(message = "Full name is required")
    val fullName: String,

    @field:Email(message = "Invalid email address")
    @field:NotBlank(message = "Email is required")
    val email: String,

    @field:NotBlank(message = "Phone number is required")
    val phoneNumber: String,

    @field:Size(min = 6, message = "Password must be at least 6 characters")
    val password: String
)
