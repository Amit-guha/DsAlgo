package com.example.problemsolving.leetcode

fun main() {
    intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))
}


fun intersect(nums1: IntArray, nums2: IntArray) : IntArray{
    val hashmap = HashMap<Int,Int>()
    val resultList =  mutableListOf<Int>()

    val shortestArray = if (nums1.size < nums2.size) nums1 else nums2
    val largestArray = if (nums1.size < nums2.size) nums2 else nums1

    for (i in shortestArray) {
        if (hashmap.contains(i)) {
            hashmap[i]?.let {
                hashmap[i] = it + 1
            }
        }else{
            hashmap[i] = 1
        }
    }

    for (i in largestArray){
        if (hashmap.contains(i)){
            hashmap[i]?.let {
                if (it != 0){
                    resultList.add(i)
                    hashmap[i] = it - 1
                }

            }
        }
    }
    println(resultList)
    return resultList.toIntArray()
}