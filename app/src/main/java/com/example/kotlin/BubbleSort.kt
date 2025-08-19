package com.example.kotlin

fun main() {
    bubbleSort(intArrayOf(3, 6, 2, 1, 8, 7, 4, 5, 3, 1))
   // bubbleSort(intArrayOf(1,2,3,4,5))
}

// 3,6,2,1,8,7,4,5,3,1
fun bubbleSort(arr: IntArray): IntArray {
    for (i in 0 until arr.size - 1) {
        var swapped = 0
        for (j in 0 until arr.size - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped ++
            }
        }
        if (swapped == 0){
            break
        }
    }
    println(arr.joinToString())
    return arr
}