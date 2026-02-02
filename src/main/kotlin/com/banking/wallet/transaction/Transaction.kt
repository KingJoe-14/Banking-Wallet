//package com.banking.wallet.transaction
//
//import com.banking.wallet.wallet.Wallet
//import jakarta.persistence.*
//import java.math.BigDecimal
//import java.time.LocalDateTime
//
//@Entity
//@Table(name = "transactions")
//class Transaction(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0,
//
//    @ManyToOne
//    @JoinColumn(name = "wallet_id", nullable = false)
//    var wallet: Wallet,
//
//    @Column(nullable = false)
//    var amount: BigDecimal,
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    var type: TransactionType,
//
//    @Column(nullable = false)
//    var createdAt: LocalDateTime = LocalDateTime.now()
//)
