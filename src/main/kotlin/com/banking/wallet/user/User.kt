package com.banking.wallet.user

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var fullName: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false, unique = true)
    var phoneNumber: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
)
