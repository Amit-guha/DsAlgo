package com.example.problemsolving.leetcode

fun main() {
    println(numWaterBottles(15, 8))
}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var quotient = numBottles
    var remainder = 0
    var totalDrinkingBottle = numBottles

    while (remainder + quotient >= numExchange) {
        val tempQuotient = (remainder + quotient) / numExchange
        remainder = (remainder + quotient) % numExchange
        quotient = tempQuotient
        totalDrinkingBottle += tempQuotient
    }

    return totalDrinkingBottle
}