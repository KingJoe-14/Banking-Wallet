package com.banking.wallet.service

@Service
class WalletService(
    private val walletRepository: WalletRepository,
    private val transactionRepository: TransactionRepository
) {

    @Transactional
    fun deposit(walletId: Long, amount: BigDecimal) {
        require(amount > BigDecimal.ZERO)

        val wallet = walletRepository.findById(walletId)
            .orElseThrow { RuntimeException("Wallet not found") }

        wallet.balance = wallet.balance.add(amount)

        transactionRepository.save(
            Transaction(
                wallet = wallet,
                amount = amount,
                type = TransactionType.DEPOSIT
            )
        )
    }

    @Transactional
    fun withdraw(walletId: Long, amount: BigDecimal) {
        require(amount > BigDecimal.ZERO)

        val wallet = walletRepository.findById(walletId)
            .orElseThrow { RuntimeException("Wallet not found") }

        if (wallet.balance < amount) {
            throw IllegalStateException("Insufficient balance")
        }

        wallet.balance = wallet.balance.subtract(amount)

        transactionRepository.save(
            Transaction(
                wallet = wallet,
                amount = amount,
                type = TransactionType.WITHDRAWAL
            )
        )
    }
}
