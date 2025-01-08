package com.example.problemsolving.leetcode

fun main() {
    println(countPrefixSuffixPairs(arrayOf("a","aba","ababa","aa")))
    println(countPrefixSuffixPairs(arrayOf("abab","ab")))
}

fun countPrefixSuffixPairs(words: Array<String>): Int {
    var count = 0
    for (i in words.indices) {
        for (j in i + 1 until words.size) {
            if (isPrefixAndSuffix(words[i], words[j])) {
                count++
            }
        }
    }

    return count
}

fun isPrefixAndSuffix(word1: String, word2: String): Boolean {
    return word2.startsWith(word1) && word2.endsWith(word1)
}
