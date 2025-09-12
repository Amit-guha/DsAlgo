package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val grid = arrayOf(
        intArrayOf(1, 7, 3),
        intArrayOf(9, 8, 2),
        intArrayOf(4, 5, 6)
    )
    val result = sortMatrix(grid)
    result.forEach { row ->
        println(row.joinToString(" "))
    }
}

/*
  for diagonal problem key is very important point.
   row index - column index = for this problem
   sometimes row index + colum index = key
   we need to find out the key
 */

@RequiresApi(Build.VERSION_CODES.N)
fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
    val hashMap = HashMap<Int, MutableList<Int>>()
    grid.forEachIndexed { index, row ->
        row.forEachIndexed { index2, item ->
            hashMap.getOrPut(index - index2) { mutableListOf() }.add(item)
        }
    }


    for ((key, list) in hashMap) {
        if (key < 0) {
            list.sort()
        } else {
            list.sortDescending()
        }
    }

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            grid[i][j] = hashMap[i - j]!!.removeAt(0)
        }
    }

    return grid

}