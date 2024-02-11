package com.iglaz.solidpractise.chapter_02.B

import java.time.LocalDate

/**
 * Доменный класс для банковских операций
 */
data class BankTransaction(
    val date: LocalDate,
    val amount: Double,
    val description: String
)

