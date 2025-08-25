package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(findDiagonalOrder(mat = arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9))).joinToString())
}

@RequiresApi(Build.VERSION_CODES.N)
fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val hashMap = HashMap<Int, MutableList<Int>>()
    val result  = mutableListOf<Int>()
    mat.forEachIndexed{ index, row ->
        row.forEachIndexed { index2, colum ->
            hashMap.getOrPut(index + index2) { mutableListOf() }.add(colum)
        }
    }

    hashMap.forEach {key, list ->
        if (key % 2 == 0) list.reverse()
        result.addAll(list)
    }

    return result.toIntArray()

}