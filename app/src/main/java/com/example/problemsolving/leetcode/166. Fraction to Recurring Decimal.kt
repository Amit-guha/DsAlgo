package com.example.problemsolving.leetcode

import kotlin.math.abs
//166. Fraction to Recurring Decimal
//Solved by taking help
fun main() {
    println(fractionToDecimal(1,2))
}

fun fractionToDecimal(numerator: Int, denominator: Int): String {
    val sb = StringBuilder()
    if (numerator == 0) return "0"
    if (numerator.toLong() * denominator.toLong() < 0) {
        sb.append("-")
    }
    val num = abs(numerator.toLong())
    val den = abs(denominator.toLong())
    sb.append(num / den)
    var rem = num % den
    if (rem == 0L) {
        return sb.toString()
    }
    sb.append(".")
    val map = mutableMapOf<Long, Int>()
    while (rem != 0L) {
        if (map.containsKey(rem)) {
            val index = map[rem]
            sb.insert(index!!, "(")
            sb.append(")")
            break
        }
        map[rem] = sb.length
        rem *= 10
        sb.append(rem / den)
        rem %= den
    }
    return sb.toString()
}