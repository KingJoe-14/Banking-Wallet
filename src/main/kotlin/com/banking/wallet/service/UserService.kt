package com.banking.wallet.service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository
) {

    fun createUser(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw IllegalArgumentException("Email already in use")
        }

        val savedUser = userRepository.save(user)

        val wallet = Wallet(
            user = savedUser,
            balance = BigDecimal.ZERO
        )
        walletRepository.save(wallet)

        return savedUser
    }
}
