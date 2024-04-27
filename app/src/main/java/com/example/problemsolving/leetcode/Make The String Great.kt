package com.example.problemsolving.leetcode

fun main() {
    println(makeGood("leEeetcode"))
    //makeGood("Pp")

}

fun makeGood(s: String): String {
    val stack = java.util.ArrayDeque<Char>()
    var goodStringResult = ""
    if (s.isEmpty()) {
        goodStringResult = ""
    } else if (s.length == 1) {
        goodStringResult = s
    } else {
        s.forEachIndexed { _, character ->
            if (stack.isEmpty() && character.isUpperCase()) {
                stack.push(character)
            } else {
                if (character.isLowerCase()) {
                    if (stack.isNotEmpty()) {
                        val lastPushCharacter = stack.peek()
                        if (lastPushCharacter!!.isUpperCase() && character == lastPushCharacter.lowercaseChar()) {
                            stack.pop()
                        } else {
                            stack.push(character)
                        }
                    } else {
                        stack.push(character)
                    }
                } else {
                    val lastPushCharacter = stack.peek()
                    if (lastPushCharacter == character.lowercaseChar() && stack.isNotEmpty()) {
                        stack.pop()
                    } else {
                        stack.push(character)
                    }
                }
            }
        }

        while (stack.isNotEmpty()) {
            goodStringResult += stack.pop()
        }

    }
    return goodStringResult.reversed()

}