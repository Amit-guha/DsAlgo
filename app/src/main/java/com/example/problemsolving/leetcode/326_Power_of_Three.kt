package com.example.problemsolving.leetcode

fun main() {
    println(isPowerOfThree(30))
}

fun isPowerOfThree(n: Int): Boolean {
    if (n <= 0) return false
    if (n == 1) return true

    var result = false
    var temp = n
    while (temp != 3) {
        if (temp % 3 != 0) {
            result = false
            break
        }
        temp /= 3
    }

    if (temp == 3) result = true
    return result
}