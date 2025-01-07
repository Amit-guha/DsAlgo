package com.example.problemsolving.leetcode

fun main() {
   // println(stringMatching(arrayOf("mass", "as", "hero", "superhero")).joinToString())
    println(stringMatching(arrayOf("leetcoder","leetcode","od","hamlet","am")).joinToString())
}

fun stringMatching(words: Array<String>): List<String> {
    val result = mutableSetOf<String>()
    for (i in 0 until words.size) {
        for (j in 0 until words.size) {
            val parentWord = words[i]
            val childWord = words[j]
            if(i == j) continue
            if (childWord.length >= parentWord.length) {
                if (childWord.contains(parentWord) && childWord != parentWord) {
                    result.add(parentWord)
                }
            }
        }
    }

    return result.toList()
}