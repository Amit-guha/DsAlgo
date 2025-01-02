package com.example.problemsolving.leetcode

fun main() {
    println(canChange(start = "_L__R__R_", target = "L______RR"))
}

fun canChange(start: String, target: String) {
    val parentCharArray = start.toCharArray()
    val childCharArray = target.toCharArray()

    for (i in parentCharArray.indices) {
        var nextIndex = if (i == parentCharArray.size - 1) {
            i
        } else {
            i + 1
        }

        val targetChar = childCharArray[i]
        val parentChar = parentCharArray[i]

        if (targetChar != parentChar) {
            if (targetChar =='L' && parentCharArray[nextIndex] == 'L' && parentChar == '_') {
                parentCharArray[i] = 'L'
                parentCharArray[nextIndex] = '_'
            }else if (targetChar == 'R' && parentCharArray[nextIndex] == 'R' && parentChar == '_') {
                parentCharArray[i] = 'R'
                parentCharArray[nextIndex] = '_'
            }else {
                if (targetChar =='_' && parentCharArray[nextIndex] =='R' && parentCharArray[nextIndex + 1] =='_'){
                    parentCharArray[nextIndex] = '-'
                    parentCharArray[nextIndex + 1] = 'R'
                    parentCharArray[i] = '_'
                }else if (targetChar =='_' && parentCharArray[nextIndex] =='L' && (parentCharArray[i-1] !='R' || parentCharArray[i - 1] =='L')){
                    parentCharArray[i] = 'L'
                    parentCharArray[i - 1] = '_'
                }

            }
        }
    }
    parentCharArray.forEach {
        println(it)
    }
}