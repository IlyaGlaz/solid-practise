package com.iglaz.solidpractise.chapter_02.B

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.stream.Collectors

/**
 * Перемещение алгоритма парсинга в отдельный класс
 */
class BankStatementCSVParser : BankStatementParser {
    override fun parseFrom(line: String?): BankTransaction? {
        val columns = line!!.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        val date = LocalDate.parse(columns[0], DATE_PATTERN)
        val amount = columns[1].toDouble()

        return BankTransaction(date, amount, columns[2])
    }

    override fun parseLinesFrom(lines: List<String?>?): List<BankTransaction?>? {
        return lines!!.stream().map { line: String? -> this.parseFrom(line) }.collect(Collectors.toList())
    }

    companion object {
        private val DATE_PATTERN: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    }
}
