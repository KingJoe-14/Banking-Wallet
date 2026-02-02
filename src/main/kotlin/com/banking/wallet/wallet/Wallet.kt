//package com.banking.wallet.wallet
//
//import com.banking.wallet.user.User
//import jakarta.persistence.*
//import java.math.BigDecimal
//import java.time.LocalDateTime
//
//@Entity
//@Table(name = "wallets")
//class Wallet(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0,
//
//    @Column(nullable = false, unique = true)
//    var walletNumber: String,
//
//    @Column(nullable = false)
//    var balance: BigDecimal = BigDecimal.ZERO,
//
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    var user: User,
//
//    @Column(nullable = false)
//    var createdAt: LocalDateTime = LocalDateTime.now()
//)
