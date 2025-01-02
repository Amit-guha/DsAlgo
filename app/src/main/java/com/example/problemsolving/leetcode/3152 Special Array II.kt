package com.example.problemsolving.leetcode

fun main() {
    println(isArraySpecial(intArrayOf(1,1), arrayOf(intArrayOf(0,1))))
   // println(isArraySpecial(intArrayOf(3,4,1,2,6), arrayOf(intArrayOf(0,4))))
   // println(isArraySpecial(intArrayOf(4,3,1,6), arrayOf(intArrayOf(0,2),intArrayOf(2,3))))
}

fun isArraySpecial(nums: IntArray, queries: Array<IntArray>) : BooleanArray {
    val booleanArrayList = mutableListOf<Boolean>()


    queries.forEachIndexed { rowIndex, row ->
        val first = row[0]
        var lasSpecial = -1
        var currentSpecial = -1
        var allConditionsSatisfied = true

        for (i in row[0]..row[1]) {
            if (nums[i] % 2 == 0) {
                if (first == i) {
                    lasSpecial = 1
                } else {
                    currentSpecial = 1
                    if (currentSpecial == lasSpecial) {
                        allConditionsSatisfied = false
                        break
                    }
                    lasSpecial = 1
                }
            } else {
                if (first == i) {
                    lasSpecial = 0
                } else {
                    currentSpecial = 0
                    if (currentSpecial == lasSpecial) {
                        allConditionsSatisfied = false
                        break
                    }
                    lasSpecial = 0
                }
            }
          //  println("Element at ${row[0]} and ${row[1]}")
        }
        booleanArrayList.add(allConditionsSatisfied)
    }
    return booleanArrayList.toBooleanArray()

}