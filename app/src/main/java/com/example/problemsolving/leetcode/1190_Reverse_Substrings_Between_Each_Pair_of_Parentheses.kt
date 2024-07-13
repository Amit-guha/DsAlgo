package com.example.problemsolving.leetcode

import java.util.Stack

fun main() {
    println(reverseParentheses("(ed(et(oc))el)"))
    //println(reverseParentheses("(u(love)i)"))
   // println(reverseParentheses("(abcd)"))
}

fun reverseParentheses(s: String) : String  {
    val stack = Stack<Char>()
    val tempStack = Stack<Char>()
    val reverseStack = Stack<Char>()
    val stringBuilder = StringBuilder()
    val converterStringArray = s.toCharArray()

    for (i in converterStringArray.indices){
        if (converterStringArray[i] == ')' || converterStringArray[i] == '}' || converterStringArray[i] == ']'){
            val stackPeekElement : Char = if (converterStringArray[i] == ')') '(' else if (converterStringArray[i] == '}') '{' else '['
            while (stack.peek() !=  stackPeekElement){
                tempStack.push(stack.pop())
            }

            if ((stack.peek() == '(' || stack.peek() == '{' ||  stack.peek() == '[' ) && stack.size != 0){
                stack.pop()
            }

            while (tempStack.isNotEmpty()) {
                reverseStack.push(tempStack.pop())
            }

            while (reverseStack.isNotEmpty()) {
                stack.push(reverseStack.pop())
            }

        }else{
            stack.push((converterStringArray[i]))
        }
    }

    while (stack.isNotEmpty()) {
        tempStack.push(stack.pop())
    }
    while (tempStack.isNotEmpty()) {
        stringBuilder.append(tempStack.pop())
    }

    return stringBuilder.toString()

}