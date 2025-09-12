package com.example.problemsolving.leetcode

fun main() {
    println(doesAliceWin("leetcoder"))
}

fun doesAliceWin(s: String): Boolean {
    var count = 0
    for (c in s) {
        if ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U') || (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
            count++
        }
    }

     return count != 0
}