package com.banking.wallet.user.dto

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val createdAt: LocalDateTime
)
