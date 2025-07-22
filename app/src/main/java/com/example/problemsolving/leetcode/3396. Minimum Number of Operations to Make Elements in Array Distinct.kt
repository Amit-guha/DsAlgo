package com.example.problemsolving.leetcode

fun main() {
    minimumOperations(intArrayOf(1,2,3,4,2,3,3,5,7))
}

fun minimumOperations(nums: IntArray) {
    var hashMap = HashMap<Int, Int>()
    nums.forEach {
        hashMap[it] = hashMap.getOrDefault(it, 0) + 1
    }
    println(hashMap)
    val frequencyMap = hashMap.values.groupingBy { it }.eachCount()
    val countGreaterThanOne = frequencyMap.count { it.value > 1 }
    println(frequencyMap)

    println(hashMap.values)
}