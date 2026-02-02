package com.banking.wallet.user.mapper

import com.banking.wallet.user.User
import com.banking.wallet.user.dto.UserResponse

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        fullName = this.fullName,
        email = this.email,
        phoneNumber = this.phoneNumber,
        createdAt = this.createdAt
    )
}
