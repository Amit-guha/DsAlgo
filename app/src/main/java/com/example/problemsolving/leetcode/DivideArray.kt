package com.example.problemsolving.leetcode

import kotlin.math.abs

//2966. Divide Array Into Arrays With Max Difference
fun main() {
    val arraysOfArray = divideArray(intArrayOf(6, 7, 7, 6, 7, 6), k = 13)
    arraysOfArray.forEachIndexed { index, _ ->
        println(arraysOfArray[index].toList())
    }
}

private fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    val parentList = mutableListOf<IntArray>()
    val itemsList = mutableListOf<Int>()

    if ((nums.size % 3 == 0)) {
        nums.sort()
        for (element in nums) {
            itemsList.add(element)
            if (itemsList.size == 3) {
                parentList.add(itemsList.toIntArray())
                if (!isCalculate(itemsList, k)) {
                    parentList.clear()
                    parentList.add(intArrayOf())
                    break
                }
                itemsList.clear()
            }
        }
    } else {
        parentList.add(intArrayOf())
    }

    return parentList.toTypedArray()

}

private fun isCalculate(parentList: MutableList<Int>, k: Int): Boolean {
    var count: Int = 0

    val firstDiff = abs(parentList[0] - parentList[1])
    val secondDiff = abs(parentList[1] - parentList[2])
    val thirdDiff = abs(parentList[0] - parentList[2])

    if (firstDiff <= k) {
        count++
    }

    if (secondDiff <= k) {
        count++
    }

    if (thirdDiff <= k) {
        count++
    }


    /*
        for (i in 0 until parentList.size) {
            for (j in i + 1 until parentList.size) {
                if (abs(parentList[i] - parentList[j]) <= k) {
                    count++
                }
            }
        }
    */

    return count == 3
}