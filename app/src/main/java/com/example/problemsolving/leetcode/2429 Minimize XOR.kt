package com.example.problemsolving.leetcode

fun main() {

}

fun minimizeXor(num1: Int, num2: Int): Int {
    // Calculate the number of set bits in num2
    val targetSetBits = Integer.bitCount(num2)

    // Initialize result to 0
    var result = 0
    var setBits = 0

    // Step 1: Copy set bits from num1 to result
    for (i in 31 downTo 0) {
        println(num1)
        if ((num1 and (1 shl i)) != 0) { // Check if the i-th bit in num1 is set
            result = result or (1 shl i) // Set the i-th bit in result
            setBits++
            if (setBits == targetSetBits) break // Stop if we have enough set bits
        }
    }

    // Step 2: Add more bits from LSB if needed
    for (i in 0..31) {
        if (setBits == targetSetBits) break // Stop if we already have enough set bits
        if ((result and (1 shl i)) == 0) { // Check if the i-th bit in result is not set
            result = result or (1 shl i) // Set the i-th bit in result
            setBits++
        }
    }

    return result

}