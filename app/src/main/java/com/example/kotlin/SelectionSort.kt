package com.example.kotlin

fun main() {
    selectionSort(intArrayOf(3, 6, 2, 1, 8, 7, 4, 5, 3, 1))
}

fun selectionSort(array: IntArray) {
    for (i in 0 until array.size - 1) {
        var minIndex = i
        for (j in i + 1 until array.size) {
            if (array[minIndex] > array[j]) {
                minIndex = j
            }
        }
        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
    println(array.joinToString())
}