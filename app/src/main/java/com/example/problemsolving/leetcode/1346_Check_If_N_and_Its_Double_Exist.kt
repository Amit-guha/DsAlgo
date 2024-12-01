package com.example.problemsolving.leetcode

fun main() {
    //val element = intArrayOf(10, 2, 5, 3)
    //val element = intArrayOf(3,1,7,11)
    //val element = intArrayOf(2,3,3,0,0)
    val element = intArrayOf(-2,0,10,-19,4,6,-8)
    println(checkIfExist(element))
}

//-19,-8,-2,0,4,6,10
fun checkIfExist(arr: IntArray): Boolean {
    val descendingArray = arr.sortedArrayDescending()
    val ascendingArray = arr.sortedArray()
    var result = 0
    var isExist = false
    val allZeroes = arr.all { it == 0 }
    if (allZeroes){
        return true
    }
    val containsAtLeastTwoZeros = arr.count { it == 0 } >= 2
    descendingArray.forEach {
        if (it % 2 == 0) {
            result = it / 2
            ascendingArray.forEach { ascElement ->
                if ((result == ascElement)) {
                    if (((it == 0 && ascElement == 0) && containsAtLeastTwoZeros) || (it != ascElement)){
                        isExist = true
                        return@forEach
                    }
                }
            }
            if (isExist) {
                return@forEach
            }

        }
    }
    return isExist

}