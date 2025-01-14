package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(
        findThePrefixCommonArray(
            A = intArrayOf(1, 3, 2, 4),
            B = intArrayOf(3, 1, 2, 4)
        ).joinToString("")
    )
}

@RequiresApi(Build.VERSION_CODES.N)
fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    val resultArray = IntArray(A.size)
    val hashMap = HashMap<Int, Int>()
    for (i in A.indices) {
        hashMap[A[i]] = hashMap.getOrDefault(A[i], 0) + 1
        hashMap[B[i]] = hashMap.getOrDefault(B[i], 0) + 1

        var count = 0
        hashMap.entries.forEachIndexed { index, mutableEntry ->
            if (mutableEntry.value > 1) {
                count++
                println("index = $i, key = ${mutableEntry.key}, value = ${mutableEntry.value}")
            }
            if (index == hashMap.entries.size - 1) {
                resultArray[i] = count

            }
        }
    }

    return resultArray
}