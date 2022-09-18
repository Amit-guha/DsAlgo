package com.example.problemsolving.leetcode

import java.util.*

//pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//946. Validate Stack Sequences
class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val tempStack = Stack<Int>()
        var j = 0
        for (v in pushed){
            tempStack.push(v)
            while(!tempStack.isEmpty() && tempStack.peek() == popped[j]){ // if st.peek() values equal to popped[j];
                tempStack.pop() // then pop out
                j++ // increment j
            }
        }
        return tempStack.isEmpty()

//        val stack = Stack<Int>()
//        val tempStack = Stack<Int>()
//        val stackSize = pushed.size
//        for (i in 0 until stackSize) {
//            for (j in 0..stackSize) { //0,1,2,3,4,5
//                if ((stack.isNotEmpty()) && (stack.peek() == popped[i])) {
//                    stack.pop()
//                    tempStack.push(popped[i])
//                    break
//                } else {
//                    if (j != pushed.size) { //highest 4
//                        if (!stack.contains(pushed[j]) && (!tempStack.contains(pushed[j]))) {
//                            stack.push(pushed[j])
//                        }
//                    } else {
//                        break
//                    }
//
//
//                }
//            }
//        }
//        return if (stack.empty()) true else false
    }

}

fun main() {
    val intArray = intArrayOf(2,1,0)   //2 ->1 ->1 -> 2 ->2 ->0 ->0
    val poppedArray = intArrayOf(2,1,0)
    val obj = Solution()
    println(obj.validateStackSequences(intArray, poppedArray))
}

