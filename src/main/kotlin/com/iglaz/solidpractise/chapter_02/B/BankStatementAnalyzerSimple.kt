package com.iglaz.solidpractise.chapter_02.B

import java.nio.file.Files
import java.nio.file.Paths
import java.time.Month
import java.util.stream.Collectors

/**
 * Использование CSV-парсера (Плохая связность)
 */
object BankStatementAnalyzerSimple {
    private const val RESOURCES = "src/main/resources/"

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bankStatementParser = BankStatementCSVParser()

        val path = Paths.get(RESOURCES + args[0])
        val lines = Files.readAllLines(path)

        val bankTransactions = bankStatementParser.parseLinesFrom(lines)

        println("The total for all transactions is " + calculateTotalAmount(bankTransactions))
        println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY))
    }

    private fun calculateTotalAmount(bankTransactions: List<BankTransaction>): Double {
        return bankTransactions.stream().mapToDouble(BankTransaction::amount).sum()
    }

    private fun selectInMonth(bankTransactions: List<BankTransaction>, month: Month): List<BankTransaction> {
        return bankTransactions.stream()
            .filter { bankStatement: BankTransaction -> month == bankStatement.date.month }
            .collect(Collectors.toList())
    }
}
