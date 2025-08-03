package com.example.problemsolving.leetcode

fun main() {
    println(doesValidArrayExist(derived = intArrayOf(1, 1, 0)))
}

fun doesValidArrayExist(derived: IntArray): Boolean {
    var bitWiseSum = 0
    derived.forEachIndexed { _, i ->
        bitWiseSum = bitWiseSum xor i
    }


    return bitWiseSum == 0
}