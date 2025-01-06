package com.example.problemsolving.leetcode

import kotlin.math.abs

fun main() {
    //minOperations("001011")
    println(minOperations("110").joinToString())
}

fun minOperations(boxes: String): IntArray {
    val intArray = boxes.map { it.toString().toInt() }.toIntArray()

    val containsOneAtParentArray = mutableListOf<Int>()
    val containsZeroAtParentArray = mutableListOf<Int>()
    val resultArray = IntArray(intArray.size)

    intArray.forEachIndexed { index, i ->
        if (i == 1) {
            containsOneAtParentArray.add(index)
        } else {
            containsZeroAtParentArray.add(index)
        }
    }

    intArray.forEachIndexed { index, i ->
        if (i == 0) {
            for (childIndex in containsOneAtParentArray) {
                val pathDistance = abs(childIndex - index)
                resultArray[index] += pathDistance
            }
        } else {
            for (childIndex in containsOneAtParentArray) {
                val pathDistance = abs(childIndex - index)
                resultArray[index] += pathDistance
            }
        }
    }

    return resultArray
}