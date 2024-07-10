package com.example.problemsolving.leetcode

import kotlin.math.min


fun main(args: Array<String>) {
    val arrayList = mutableListOf(1, 5, 0, 10, 14)
    println(minDifference(nums = arrayList.toIntArray()))
}

fun minDifference(nums: IntArray): Int {
    if (nums.size <= 4) return 0
    nums.sort()
    var minValue = Int.MAX_VALUE
    for (i in 0..3) {
        minValue = min(minValue, nums[nums.size - 1 - i] - nums[3 - i])
    }
    return minValue



    /*
    1, 5, 0, 10, 14
    0,1,5,10,14 (sorted array)
    14 - 10 = 4 (first three are equal so they are omitted)
    10 - 5 = 5 (first two  and last one are equal so they are omitted)
    5 - 1 = 4 (first one  and last two are equal so they are omitted)
    1 - 0 = 1 (lst three are equal so they are omitted)

     */

}