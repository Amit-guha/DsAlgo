package com.example.problemsolving.leetcode

fun main() {
    println(plusOne(digits = intArrayOf(1, 2, 3)).joinToString())
}

fun plusOne(digits: IntArray): IntArray {
    val resultArray = IntArray(digits.size + 1)
    var extra = 0

    for (i in digits.size - 1 downTo 0) {
        val sum = if (i == digits.size - 1) digits[i] + 1 else digits[i] + extra
        if (sum == 10) {
            resultArray[i + 1] = 0
            extra = 1
        } else {
            extra = 0
            resultArray[i + 1] = sum
        }
    }

    if (extra != 0) {
        resultArray[0] = extra
    }

    return if (resultArray[0] == 0)
        resultArray.copyOfRange(1, resultArray.size)
    else {
        resultArray
    }
}