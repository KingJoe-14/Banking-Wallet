package com.banking.wallet.user.service

import com.banking.wallet.user.User
import com.banking.wallet.user.UserRepository
import com.banking.wallet.user.dto.CreateUserRequest
import com.banking.wallet.user.dto.UserResponse
import com.banking.wallet.user.mapper.toResponse

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun createUser(request: CreateUserRequest): UserResponse {

        // Check if email already exists
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email already registered")
        }

        // Check if phone already exists
        if (userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw IllegalArgumentException("Phone number already registered")
        }

        val user = User(
            fullName = request.fullName,
            email = request.email,
            phoneNumber = request.phoneNumber,
            password = passwordEncoder.encode(request.password),
            createdAt = LocalDateTime.now()
        )

        return userRepository.save(user).toResponse()
    }
}
