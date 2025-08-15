package com.example.problemsolving.leetcode

fun main() {
    println(isPowerOfFour(30))
}

fun isPowerOfFour(n: Int): Boolean {
    if (n <= 0) return false
    if (n == 1) return true

    var result = false
    var temp = n
    while (temp != 4) {
        if (temp % 4 != 0) {
            result = false
            break
        }
        temp /= 4
    }

    if (temp == 4) result = true
    return result
}