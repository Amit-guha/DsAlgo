package com.example.problemsolving.leetcode

fun main() {
    //(numberOfPairs(points = arrayOf(intArrayOf(6, 2), intArrayOf(4, 4), intArrayOf(2, 6))))
    //reverseArray()
    // subArray()
   // maxSubArraySum()
    kadanesAlgorithm()
}

fun numberOfPairs(points: Array<IntArray>) {
    for (i in 0 until points.size) {
        println(points[i].joinToString())
    }
}


fun reverseArray() {
    val array = intArrayOf(10, 20, 30, 40, 50)
    var start = 0
    var end = array.size - 1

    while (start < end) {
        val temp = array[end]
        array[end] = array[start]
        array[start] = temp

        start++
        end--

        println("start -> $start,   end ->$end")
    }

    println(array.joinToString())

}
//01718760052

fun subArray() {
    var sum = 0
    var maxSum = Int.MIN_VALUE
    var minSum = 0
    var lowerBound = 0
    val array = intArrayOf(10, 20, 30, 40, 50)
    for (i in 0 until array.size) {
        minSum = array[0]
        lowerBound = array[0]
        for (j in i until array.size) {
            sum = 0
            for (k in i..j) {
                sum += array[k]
                print("${array[k]} ")
            }
            maxSum = maxOf(maxSum, sum)
            minSum = minOf(minSum, lowerBound)
            println()
        }
    }

    println("maxSum ->$maxSum , minSum ->$minSum")
}

fun maxSubArraySum() {
    val array = intArrayOf(10, 20, 30, 40, 50)
    var maxSum = Int.MIN_VALUE
    var sum = 0

    val prefixArray = Array(array.size) { 0 }
    prefixArray[0] = array[0]

    for (i in 1 until array.size) {
        prefixArray[i] = array[i] + prefixArray[i - 1]
    }

    println(prefixArray.joinToString())

    for (i in 0 until array.size) {
        for (j in i until array.size) {
            sum = if (i == 0) prefixArray[j] else prefixArray[j] - prefixArray[i - 1]
            maxSum = maxOf(sum, maxSum)
        }
    }
    println(maxSum)
}

fun kadanesAlgorithm() {
    val arrayInfo = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
   // val arrayInfo = intArrayOf(10, 20, 30, 40, 50)
    var currentSum = 0
    var maxSum = Int.MIN_VALUE

    for (i in 0 until arrayInfo.size) {
        currentSum += arrayInfo[i]
        if (currentSum < 0) {
            currentSum = 0
        }
        maxSum = maxOf(currentSum, maxSum)
    }
    println(maxSum)
}
