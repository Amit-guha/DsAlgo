package com.example.problemsolving.leetcode

fun main() {
    println(minBitFlips(3, 4))
}

fun minBitFlips(start: Int, goal: Int): Int {
    return ((start xor goal).toString(2).count { it == '1' })

    /*var count = 0
    var startBinary = start.toString(2)
    var goalBinary = goal.toString(2)

    if (startBinary.length < goalBinary.length) {
        startBinary = startBinary.padStart(goalBinary.length, '0')
    }

    if (goalBinary.length < startBinary.length) {
        goalBinary = goalBinary.padStart(startBinary.length, '0')
    }

    for (i in startBinary.indices) {
        if (startBinary[i] != goalBinary[i]) {
            count++
        }
    }
    return count*/
}