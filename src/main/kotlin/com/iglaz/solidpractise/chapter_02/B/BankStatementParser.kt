package com.iglaz.solidpractise.chapter_02.B

/**
 * Интерфейс для классов - парсеров
 */
interface BankStatementParser {
    fun parseFrom(line: String): BankTransaction
    fun parseLinesFrom(lines: List<String>): List<BankTransaction>
}
