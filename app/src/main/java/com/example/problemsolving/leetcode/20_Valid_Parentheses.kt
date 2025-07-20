package com.example.problemsolving.leetcode
import java.util.Stack

fun main() {
    println(isValid("()[]{}"))
    println(isValid("([])"))
    println(isValid("(]"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    s.toCharArray().forEachIndexed { index, ch ->
        if (stack.isEmpty()){
            stack.push(ch)
        }else{
            if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']')) {
                stack.pop()
            }else{
                stack.push(ch)
            }
        }
    }
    return stack.isEmpty()
}