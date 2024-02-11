package com.iglaz.solidpractise.chapter_02.A

import java.nio.file.Files
import java.nio.file.Path

/**
 * Какова общая сумма списаний и начислений по списку операций.
 */
object BankStatementAnalyzerSimple {
    private const val RESOURCES = "src/main/resources/"
    private const val FILE_NAME = "bank-data-simple.csv"

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val path = Path.of(RESOURCES, FILE_NAME)
        val lines = Files.readAllLines(path)
        var total = 0.0
        for (line in lines) {
            val columns = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val amount = columns[1].toDouble()
            total += amount
        }

        println("The total for all transactions is $total")
    }
}
