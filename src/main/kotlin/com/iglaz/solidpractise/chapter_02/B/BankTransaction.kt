package com.iglaz.solidpractise.chapter_02.B

import java.time.LocalDate
import java.util.*

class BankTransaction(val date: LocalDate,
                      val amount: Double,
                      val description: String) {
    override fun toString(): String {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as BankTransaction
        return java.lang.Double.compare(
            that.amount,
            amount
        ) == 0 && date == that.date && description == that.description
    }

    override fun hashCode(): Int {
        return Objects.hash(date, amount, description)
    }
}
