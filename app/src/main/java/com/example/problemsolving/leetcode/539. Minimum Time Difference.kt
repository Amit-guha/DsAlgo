package com.example.problemsolving.leetcode

import kotlin.math.abs

fun main() {
    println(findMinDifference(mutableListOf("05:31","22:08","00:35")))
}

fun findMinDifference(timePoints: List<String>): Int {
    val minuteList = mutableListOf<Int>()
    timePoints.forEach {
        val splitTimePoint = it.split(":")

        val timeInMinute = if (splitTimePoint[0].toInt() == 0) {
            24 * 60 + splitTimePoint[1].toInt()
        } else {
            splitTimePoint[0].toInt() * 60 + splitTimePoint[1].toInt()
        }
        minuteList.add(timeInMinute)
    }

    println(minuteList)
    minuteList.sort()
   val minResult =  if (minuteList.size >= 2) {
        abs(minuteList[0] - minuteList[1])
    } else {
        abs(minuteList[0])
    }

    minuteList.sortDescending()
    val maxResult = if (minuteList.size >= 2) {
        abs(minuteList[0] - minuteList[1])
    } else {
        abs(minuteList[0])

    }

    return if (minResult < maxResult) minResult else maxResult


}