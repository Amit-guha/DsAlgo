package com.example.problemsolving.leetcode

fun main() {
    val inputString = "aababbab"
    println(minimumDeletions(inputString))
}

fun minimumDeletions(s: String): Int {
    var deleteCount = 0
    val inputCharArray = s.toMutableList()
    var i = 0
    return if (s.isNotEmpty()) {
        while (i in 0 until inputCharArray.size - 2) {
            val charArray = inputCharArray.toCharArray()
            println(charArray)
            println(i)
            if (charArray[i] == 'b' && charArray[i + 1] == 'a') {
                deleteCount++
                inputCharArray.removeAt(i)
                i = 0
            } else {
                i++
            }
        }
        deleteCount
    } else {
        0
    }

}