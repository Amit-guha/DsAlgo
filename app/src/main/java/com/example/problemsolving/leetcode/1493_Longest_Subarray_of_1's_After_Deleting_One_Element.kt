package com.example.problemsolving.leetcode

fun main() {
    /*println(longestSubarray(nums = intArrayOf(1, 1, 0, 1)))

    println(longestSubarray(nums = intArrayOf(1,1,1)))*/
    println(longestSubarray(nums = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
    println(longestSubarray(nums = intArrayOf(1, 1, 0, 0, 1, 1, 1, 0, 1)))
    println(longestSubarray(nums = intArrayOf(1, 0, 0, 0, 0)))
}

//0,1,1,1,0,1,1,0,1
fun longestSubarray(nums: IntArray): Int {
    var largestSum = 0
    val insertionValue = mutableListOf<Int>()
    val insertionIndex = mutableListOf<Int>()
    var count = 0

    if (nums.all { it == 1 }) return nums.size - 1

    for (i in 0 until nums.size) {
        if (nums[i] == 0) {
            if (count != 0) {
                insertionValue.add(count)
                insertionIndex.add(i - 1)
                count = 0
            }
        } else {
            count++
        }
    }

    if (count != 0) {
        insertionValue.add(count)
        insertionIndex.add(nums.size - 1)
    }

    for (i in 0 until insertionIndex.size){
        if (i+1 < insertionIndex.size){
            val previousIndex = insertionIndex[i]
            val nextValue = insertionValue[i+1]
            val nextIndex = insertionIndex[i+1] - nextValue

            if (previousIndex + 1 == nextIndex){
                largestSum = maxOf(largestSum, insertionValue[i] + insertionValue[i+1])
            }else{
                if (insertionValue[i] > insertionValue[i+1]){
                    largestSum = maxOf(largestSum, insertionValue[i])
                }else{
                    largestSum = maxOf(largestSum, insertionValue[i+1])
                }
            }
        }else{
            largestSum = maxOf(largestSum, insertionValue[i])
        }
    }

    return largestSum
}