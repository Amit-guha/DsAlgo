package com.example.problemsolving.leetcode

fun main() {
//println(minSwaps(intArrayOf(0,1,1,1,0,0,1,1,0)))
println(minSwaps(intArrayOf(1,1,0,0,1)))
}

fun minSwaps(nums: IntArray): Int {
    val n = nums.size
    val totalOnes = nums.count { it == 1 }
    if (totalOnes == 0) {
        return 0
    }

    val extendedArray = nums + nums
    var maxOnesInWindow: Int
    var currentOnesInWindow = 0
    var left = 0

    for(right in  0 until totalOnes){
        if (extendedArray[right] == 1) currentOnesInWindow ++
    }

    maxOnesInWindow = currentOnesInWindow

    for (right in totalOnes until totalOnes + n){
        if (extendedArray[right] == 1) currentOnesInWindow ++
        if (extendedArray[left] == 1) currentOnesInWindow --

        maxOnesInWindow = maxOf(maxOnesInWindow, currentOnesInWindow)
        left ++

    }
    return totalOnes - maxOnesInWindow

}