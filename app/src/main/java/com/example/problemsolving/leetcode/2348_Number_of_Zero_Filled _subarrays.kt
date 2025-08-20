package com.example.problemsolving.leetcode

fun main() {
    println(zeroFilledSubarraySolution2(intArrayOf(1, 3, 0, 0, 2, 0, 0, 4)))
    println(zeroFilledSubarraySolution2(intArrayOf(0, 0, 0, 2, 0, 0)))
    println(zeroFilledSubarraySolution2(intArrayOf(2, 10, 2019)))
}

//1,3,0,0,2,0,0,4
//0, 0, 0, 2, 0, 0
fun zeroFilledSubarray(nums: IntArray): Long {
    var count = 0L
    var p = 0
    var q = 0

    val allZeros = nums.all { it == 0 }
    if (allZeros) {
        return nums.size.toLong() * (nums.size + 1) / 2
    }

    while (p <= nums.size - 1) {
        if (nums[p] == 0 && nums[q] == 0) {
            count++
            if (q == nums.size - 1) {
                p = p + 1
                q = p
            } else {
                q = q + 1
            }
        } else {
            p = p + 1
            q = p
        }
    }
    return count
}

fun zeroFilledSubarraySolution2(nums: IntArray): Long {
    var count = 0L
    var subArray = 0L
    for (num in nums) {
        if (num == 0) {
            count++
        } else {
            subArray += (count * (count + 1)) / 2
            count = 0
        }
    }

    subArray += (count * (count + 1)) / 2
    return subArray

}