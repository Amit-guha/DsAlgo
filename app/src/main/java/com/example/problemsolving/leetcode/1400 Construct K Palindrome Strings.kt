package com.example.problemsolving.leetcode

import android.annotation.SuppressLint

fun main() {
 //println(canConstruct("annabelle",2))
 //println(canConstruct("leetcode",3))
 //println(canConstruct("true",4))
 println(canConstruct("yzyzyzyzyzyzyzy",2))
}

/**
 * Determines if a given string can be constructed into a specified number of palindromic strings.
 *
 * A palindromic string is a string that reads the same forwards and backward.
 * This function checks if a given string `sourceString` can be rearranged into `maxPalindromes`
 * palindromic strings.
 *
 * The logic is based on the fact that:
 *  1. A palindrome can have at most one character with an odd count.
 *  2. To form `k` palindromes, we need at most `k` characters with odd counts.
 *
 * For example:
 * - "aabbc" can form 2 palindromes ("aba" and "c"). Odd counts: 'c' (1).
 * - "aabbccd" can form 3 palindromes ("aba", "cdc", and another character using the other b). Odd counts: c, d (2).
 * - "aabbccdd" can form 4 palindromes ("a", "b", "c", "d"). Odd counts: none.
 * - "aab" can form 2 palindromes ("aa" and "b")
 * - "" can form 0 palindromes.
 *
 * @param sourceString The string to be checked.
 * @param maxPalindromes The maximum number of palindromic strings that can be formed.
 * @return `true` if the `sourceString` can be constructed into `maxPalindromes` palindromic strings, `false` otherwise.
 *
 * @throws IllegalArgumentException if maxPalindromes is negative.
 *
 * @SuppressLint("NewApi")
 */
@SuppressLint("NewApi")
fun canConstruct(sourceString: String, maxPalindromes: Int): Boolean {
    if (sourceString.length < maxPalindromes) return false
    val charCounts = HashMap<Char, Int>()
    sourceString.forEach {
        charCounts[it] = charCounts.getOrDefault(it, 0) + 1
    }

    var oddCharCount = 0
    println(charCounts)
    charCounts.forEach { (key, value) ->
        if (value % 2 != 0) {
            oddCharCount ++
        }
    }

    println(oddCharCount)
    return oddCharCount <= maxPalindromes
}