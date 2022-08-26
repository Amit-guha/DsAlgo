package com.example.ds.stack

import java.util.*
import kotlin.collections.ArrayList

class Build_an_Array_With_Stack_Operations {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val stringList = ArrayList<String>()
        val stack = Stack<Int>()
        var isCheck = false
        for (i in 0 until n) {
            if (stack.size == target.size) {
                break
            } else {
                stack.push(i + 1)
                stringList.add("Push")

                for (index in 0 until target.size) {
                    if (target.get(index) == stack.peek()) {
                        isCheck = true
                        break
                    } else {
                        isCheck = false
                    }
                }

                if (isCheck == false) {
                    if (stack.isNotEmpty()) {
                        stack.pop()
                        stringList.add("Pop")
                    }
                }

            }
        }

        return stringList
    }
}

fun main() {
    val target = IntArray(2)
    target[0] = 1
    target[1] = 2
    val n = 4

    val obj = Build_an_Array_With_Stack_Operations()
    val returnListOfString: List<String> = obj.buildArray(target, n)

    println(returnListOfString)

}