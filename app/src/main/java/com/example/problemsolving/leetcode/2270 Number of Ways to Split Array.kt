package com.example.problemsolving.leetcode

import kotlin.math.abs

fun main() {
   println(waysToSplitArray(intArrayOf(10,4,-8,7)))
  // println(waysToSplitArray(intArrayOf(-2,-5,-12,-13)))
}

fun waysToSplitArray(nums: IntArray): Int {
    var count = 0
    val prefixSumArray = LongArray(nums.size + 1)
    for (i in nums.indices) {
        prefixSumArray[i + 1] = prefixSumArray[i] + nums[i]
    }

    for (i in 1 until prefixSumArray.size - 1) {
        val leftSum : Long = prefixSumArray[i]
        val rightSum : Long = (prefixSumArray[nums.size]) - prefixSumArray[i]
        println("left sum -->$leftSum --->right Sum -->$rightSum")
        if (leftSum>=rightSum){
            count++
        }

    }

    return count
}

/*
var count = 0
var sum : Long = 0

for (i in nums.indices) {
    sum +=nums[i]
}

var leftSum : Long = 0
var rightSum : Long = sum

for (i in 0 until nums.size - 1) {
    leftSum += nums[i]
    rightSum -= nums[i]

    if (leftSum >= rightSum) {
        count++
    }

}

return count*/
