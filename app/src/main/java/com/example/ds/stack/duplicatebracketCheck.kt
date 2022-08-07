package com.example.ds.stack

import java.util.*

class duplicatebracketCheck {
}

fun main() {
    val str = readln().trim().toString()
    val stack = Stack<Char>()

    for (i in 0 until str.length) {
        val char = str[i]
        if (char == ')') {
            if (stack.peek() == '(') {
                println(true)
                return
            } else {
                while (stack.peek() != '(') {
                    stack.pop()
                }
                stack.pop()
            }
        } else {
            stack.push(str[i])
        }
    }
    println(false)

}

