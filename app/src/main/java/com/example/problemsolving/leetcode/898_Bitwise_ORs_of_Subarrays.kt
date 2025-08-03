package com.example.problemsolving.leetcode

fun main() {
  //  println(subarrayBitwiseORs2(arr = intArrayOf(1,2,4)))

  /*  val totalVersions = 10
    val firstBadVersion = findFirstBadVersion(totalVersions)

    if (firstBadVersion == -1) {
        println("There is no bad version.")
    } else {
        println("First bad version is: $firstBadVersion")
    }*/

    val nums = arrayOf("102", "473", "251", "814")
    val queries = arrayOf(intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(4, 2))

    val result = smallestTrimmedNumbers(nums, queries)
    println(result.joinToString())


}

var firstBadVersionNumber = 4
fun isBadVersion(version: Int): Boolean {
    if (firstBadVersionNumber <= 0) return false
    return version >= firstBadVersionNumber
}

fun findFirstBadVersion(totalVersions: Int): Int {
    var first = 1
    var last = totalVersions

    while (first < last) {
        val middle = first + (last - first) / 2

        if (isBadVersion(middle)) {
            last = middle
        } else {
            first = middle + 1
        }
    }

    return if (isBadVersion(first)) first else -1
}


fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val answer = IntArray(queries.size)

    for ((qIndex, query) in queries.withIndex()) {
        val k = query[0]
        val trim = query[1]

        val trimmed = nums.mapIndexed { index, num ->
            val trimmedNum = num.substring(num.length - trim)
            index to trimmedNum
        }

        val sorted = trimmed.sortedWith(compareBy({ it.second }, { it.first }))
        answer[qIndex] = sorted[k - 1].first
    }

    return answer
}



fun subarrayBitwiseORs(arr: IntArray): Int {
    if (arr.size == 1) return 1
    val subItemList = mutableSetOf<Long>()
    for (i in 0 until arr.size) {
        var result = 0L
        for (j in i until arr.size) {
            result = arr[j].toLong() or result
            subItemList.add(result)
        }
    }
    return  subItemList.size
}



fun subarrayBitwiseORs2(arr: IntArray): Int {
    var prevSet = mutableSetOf<Int>()
    val result = mutableSetOf<Int>()

    for(num in arr){
        val currentSet = mutableSetOf<Int>()
        currentSet.add(num)

        for(prev in prevSet){
            currentSet.add(prev or num)
        }
        result.addAll(currentSet)
        prevSet = currentSet
    }
    return result.size
}
