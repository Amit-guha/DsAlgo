package com.example.problemsolving.leetcode

import java.util.Stack

fun main() {
    // println(maximumGainSecondAttempt("cdbcbbaaabab", 4, 5))
    println(maximumGainSecondAttempt("aabbaaxybbaabb", 5, 4))

}

fun maximumGain(s: String, x: Int, y: Int): Int {
    val charArray = s.toMutableList()
    var index = 0
    var baValue = 0
    var abValue = 0
    var exit = 0
    var operationType = if (x > y) "ab" else "ba"

    while (exit != 2) {
        if ((index != charArray.size - 1) && (operationType == "ba")) {
            if (charArray[index] == 'b' && charArray[index + 1] == 'a') {
                baValue++
                charArray.removeAt(index)
                charArray.removeAt(index)
                index = 0
            } else {
                index++
            }
        } else {
            if ((index == charArray.size - 1) && (operationType == "ba")) {
                index = 0
                exit++
                operationType = "ab"
            }
        }

        if (index != charArray.size - 1 && operationType == "ab") {
            if (charArray[index] == 'a' && charArray[index + 1] == 'b') {
                abValue++
                charArray.removeAt(index)
                charArray.removeAt(index)
                index = 0
            } else {
                index++
            }
        } else {
            if ((index == charArray.size - 1) && (operationType == "ab")) {
                index = 0
                exit++
                operationType = "ba"
            }
        }
    }
    return abValue * x + baValue * y

}

fun removeSubString(charArray: CharArray, pairChar: String, score: Int): Pair<Int, String> {
    var totalScore = 0
    val stack = Stack<Char>()
    val firstChar = pairChar.first()
    val secondChar = pairChar.last()

    for (i in charArray.indices) {
        if (stack.isNotEmpty() && stack.peek() == firstChar && charArray[i] == secondChar) {
            stack.pop()
            totalScore += score
        } else {
            stack.push(charArray[i])
        }
    }
    val tempStack = Stack<Char>()
    val stringBuilder = StringBuilder()
    while (stack.isNotEmpty()) {
        tempStack.push(stack.pop())
    }

    while (tempStack.isNotEmpty()) {
        stringBuilder.append(tempStack.pop())
    }


    return Pair(totalScore, stringBuilder.toString())


}

fun maximumGainSecondAttempt(s: String, x: Int, y: Int): Int {
    var str = s
    var score = 0
    val firstPair = if (x > y) "ab" else "ba"
    val secondPair = if (firstPair == "ab") "ba" else "ab"

    var result = removeSubString(str.toCharArray(), firstPair, Math.max(x,y))
    score += result.first
    str = result.second


    result = removeSubString(str.toCharArray(), secondPair, Math.min(x,y))
    score += result.first

    return score

}