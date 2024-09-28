package com.example.problemsolving.leetcode

fun main() {
    println(getLucky("leetcode", 2))
}

fun getLucky(s: String, k: Int) : Int {
    val charArray = s.toCharArray()
    var charSumStringBuilder = StringBuilder()
    var sum = 0
    var i = 0

    charArray.forEachIndexed { _, char ->
        charSumStringBuilder.append(char.lowercaseChar().code - 'a'.code + 1)
    }

    while (i != k) {
        sum = 0
        charSumStringBuilder.forEach {
            sum += it.digitToInt()
        }
        charSumStringBuilder = StringBuilder(sum.toString())
        i++
    }

   return sum

}