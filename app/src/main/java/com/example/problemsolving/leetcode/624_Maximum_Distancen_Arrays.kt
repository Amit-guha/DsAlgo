package com.example.problemsolving.leetcode

import kotlin.math.absoluteValue

fun main() {
   /*  val arrays = listOf(
         listOf(1, 2, 3),
         listOf(4, 5),
         listOf(1,2,3)
     )*/

    /*val arrays = listOf(
        listOf(1),
        listOf(1)
    )*/

    val arrays = listOf(
        listOf(1, 5),
        listOf(3, 4)
    )

    println(maxDistance(arrays))
}

fun maxDistance(arrays: List<List<Int>>): Int {
    val maxValue = arrays.map { it.maxOrNull() ?: 0 }
    val minValue = arrays.map { it.minOrNull() ?: 0 }

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    var ignoreIndex = -1

    var minValueBasedOnMin = Int.MAX_VALUE
    var maxValueBasedOnMin = Int.MIN_VALUE
    var ignoreIndexBasedOnMIn = -1

    maxValue.forEachIndexed { index, i ->
        if (i > max) {
            max = i
            ignoreIndex = index
        }
    }

    minValue.forEachIndexed { index, i ->
        if (i < min && index != ignoreIndex) {
            min = i
        }
    }

    minValue.forEachIndexed { index, i ->
        if (i < minValueBasedOnMin) {
            minValueBasedOnMin = i
            ignoreIndexBasedOnMIn = index

        }
    }

    maxValue.forEachIndexed { index, i ->
        if (i > maxValueBasedOnMin && index != ignoreIndexBasedOnMIn) {
            maxValueBasedOnMin = i
        }
    }

    val resultBasedOnMaxValue = (max - min).absoluteValue
    val resulBaseOnMinValue = (maxValueBasedOnMin - minValueBasedOnMin).absoluteValue

    return if (resulBaseOnMinValue > resultBasedOnMaxValue) resulBaseOnMinValue else resultBasedOnMaxValue
}