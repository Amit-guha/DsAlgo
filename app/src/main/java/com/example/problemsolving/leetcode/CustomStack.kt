package com.example.problemsolving.leetcode

import java.util.*

//1381. Design a Stack With Increment Operation
class CustomStack(maxSize: Int) {
    val stack = Stack<Int>()
    val stackMaxSize = maxSize
    fun push(x: Int) {
        if (stack.size != stackMaxSize) {
            stack.push(x)
        }

    }

    fun pop(): Int {
        return if (stack.isNotEmpty()) {
            stack.pop()
        } else
            -1
    }

    fun increment(k: Int, `val`: Int) {
       val length = if (k > stack.size) stack.size else k
        for (i in 0 until length){
           // println(i)
            stack[i] = stack[i] + `val`
        }

    }
}

fun main() {
    val customStack = CustomStack(3)
    customStack.push(1)                         // stack becomes [1]
    customStack.push(2)                          // stack becomes [1, 2]
    println(customStack.pop())
    customStack.push(2)                          // stack becomes [1, 2]
    customStack.push(3)                          // stack becomes [1, 2, 3]
    customStack.push(4)
    customStack.increment(5, 100)           // stack becomes [101, 102, 103]
    println(customStack.stack)
    customStack.increment(2, 100)
    println(customStack.stack)
    println(customStack.pop())
    println(customStack.pop())
    println(customStack.pop())
    println(customStack.pop())
}