package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    println(repeatedNTimes(nums = intArrayOf(1,2,3,3)))
}


@RequiresApi(Build.VERSION_CODES.N)
fun repeatedNTimes(nums: IntArray): Int {
    val hashMap = HashMap<Int,Int>()
    for (num in nums) {
        hashMap[num] = hashMap.getOrDefault(num, 0) + 1
    }

    for ((key, value) in hashMap) {
        if (value> 1) {
            return key
        }
    }

    return -1
}