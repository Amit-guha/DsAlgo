package com.example.problemsolving.leetcode

fun main() {
    println(
        // makeFancyString("aabaabaabaa")
        makeFancyString("leeetcode")
        //makeFancyString("aaa")
    )
}

fun makeFancyString(s: String): String {
    var firstPointer = 0
    var secondPointer = 1
    val result = StringBuilder()
    var count = 0

    if (s.length <= 2) return s


    for ((index, _) in s.withIndex()) {
        if (firstPointer == s.length - 1) {
            break
        }
        if (s[firstPointer] != s[secondPointer]) {
            if (count >= 2) count = 0 else {
                count = 0
                result.append(s[firstPointer])
            }

            if (index == s.length - 2) {
                result.append(s[secondPointer])
                break
            }
        }

        if (s[firstPointer] == s[secondPointer]) {
            if (count < 2) {
                result.append(s[firstPointer])
            }
            count++

            if (secondPointer == s.length - 1 && count <2) {
                result.append(s[secondPointer])
                break
            }
        }

        firstPointer++
        secondPointer++

    }
    return result.toString()
}

fun highestWord() {
    var maxArray = ""
    var maxScore = 0
    val currentString = "abid is ok"
    val string = "abcdefghijklmnopqrstuvwxyz"
    val array = currentString.split(" ")

    array.forEachIndexed { index, value ->
        var score = 0
        value.forEach {
            score += string.indexOf(it) + 1
        }
        if (score > maxScore) {
            maxScore = score
            maxArray = value
        }

    }

    println(maxArray)
}

fun uppercaseString() {
    val input = "userData"
    var stringBuilder = StringBuilder()
    input.forEachIndexed { index, it ->
        if (it.isUpperCase()) {
            println(input.split(it))

        }
    }
}
// leeetcode
// le ee ee et tc co od de
//lee