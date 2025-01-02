package com.example.problemsolving.leetcode


fun main() {
    val words = listOf("aba", "bcb", "ece", "aa", "e")
    val queries = listOf(listOf(0, 2), listOf(1, 4), listOf(1, 1))
    vowelStrings(words,queries)
}

fun vowelStrings(words: List<String>, queries: List<List<Int>>) {
    fun isVowelString(word: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return if (word.isNotEmpty() && word.first() in vowels && word.last() in vowels) 1 else 0
    }

    // Step 1: Precompute `vowelCounts`
    val vowelCounts = IntArray(words.size) { isVowelString(words[it]) }

    val prefixSumArray = IntArray(words.size + 1)
    for (i in words.indices) {
        prefixSumArray[i + 1] = prefixSumArray[i] + vowelCounts[i]
    }


    val result = IntArray(queries.size)
    for (q in queries.indices) {
        val (start, end) = queries[q]
        result[q] = prefixSumArray[end + 1] - prefixSumArray[start]
    }

    result.forEach {
        println(it)
    }

   // return result
}