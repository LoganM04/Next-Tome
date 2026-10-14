package com.lmcoding.nexttome.domain.model

import kotlin.jvm.JvmInline

@JvmInline
value class Isbn private constructor(val value: String){
    companion object{
        fun parse(raw: String) : Isbn? {
            val cleaned = raw.uppercase().filter {
                it.isDigit()
                || it == 'X'
            }
            val valid = when(cleaned.length){
                13 -> cleaned.all { it.isDigit() } && isValidIsbn13(cleaned)
                10 -> isValidIsbn10(cleaned)
                else -> false
            }
            return if(valid) Isbn(cleaned) else null
        }

        private fun isValidIsbn13(isbn: String): Boolean{
            val sum = isbn.mapIndexed { i, c -> c.digitToInt() * if (i % 2 == 0) 1 else 3 }.sum()
            return sum % 10 == 0
        }

        private fun isValidIsbn10(isbn: String): Boolean {
            if (!isbn.take(9).all { it.isDigit() }) return false
            val sum = isbn.mapIndexed { i, c ->
                val value = if (c == 'X' && i == 9) 10 else c.digitToIntOrNull() ?: return false
                value * (10 - i)
            }.sum()
            return sum % 11 == 0
        }
    }
}