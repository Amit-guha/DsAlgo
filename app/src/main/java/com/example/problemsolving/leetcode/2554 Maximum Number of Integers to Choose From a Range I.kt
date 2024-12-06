package com.example.problemsolving.leetcode

fun main() {
    println(maxCount(banned = intArrayOf(1, 6, 5), n = 5, maxSum = 6))
}

fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
    var sum = 0
    var count = 0
    val hashSet = HashSet<Int>()
    banned.forEach {
        hashSet.add(it)
    }

    for (i in 1..n) {
        if (!hashSet.contains(i)) {
            sum += i
            if (sum > maxSum) {
                break
            }else{
                count++
            }
        }
    }
    return count
}