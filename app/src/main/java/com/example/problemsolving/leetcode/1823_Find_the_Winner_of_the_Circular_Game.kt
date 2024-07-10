package com.example.problemsolving.leetcode

fun main() {
   println(findTheWinner(5,2))
}

fun findTheWinner(n: Int, k: Int): Int {
    val items = (1..n).toMutableList()
    var iterations = 0
    var index = 0
    while (items.size > 1) {
        iterations++
        index %= items.size
        if (iterations == k) {
            items.removeAt(index)
            iterations = 0
            index %= items.size
        }else{
            index ++
        }
    }

    return items.first()
}