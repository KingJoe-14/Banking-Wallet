package com.banking.wallet.user.controller

import com.banking.wallet.user.dto.CreateUserRequest
import com.banking.wallet.user.dto.UserResponse
import com.banking.wallet.user.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun registerUser(
        @Valid @RequestBody request: CreateUserRequest
    ): ResponseEntity<UserResponse> {

        val response = userService.createUser(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}
