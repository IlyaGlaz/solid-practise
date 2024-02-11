package com.iglaz.solidpractise.chapter_02.A

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

/**
 * Проблема, когда надо написать логику для другого вида операций. Например - вычислить сумму транзакций за январь.
 */
object BankStatementAnalyzerProblematic {
    private const val RESOURCES = "src/main/resources/"
    private const val FILE_NAME = "bank-data-simple.csv"
    private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val path = Paths.get(RESOURCES + FILE_NAME)
        val lines = Files.readAllLines(path)
        var total = 0.0
        for (line in lines) {
            val columns = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val amount = columns[1].toDouble()
            total += amount
        }

        println("The total for all transactions is $total")

        total = 0.0
        for (line in lines) {
            val columns = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val date = LocalDate.parse(columns[0], DATE_FORMATTER)
            if (date.month == Month.JANUARY) {
                val amount = columns[1].toDouble()
                total += amount
            }
        }

        println("The total for all transactions in January is $total")
    }
}
