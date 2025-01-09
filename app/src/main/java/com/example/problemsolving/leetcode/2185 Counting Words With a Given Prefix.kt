package com.example.problemsolving.leetcode

fun main() {
   println(prefixCount(words = arrayOf("pay", "attention", "practice", "attend"), pref = "at"))
}

fun prefixCount(words: Array<String>, pref: String): Int {
    var count = 0
    words.forEachIndexed { index, s ->
        if (s.startsWith(pref)) {
            count++
        }
    }

    return count
}