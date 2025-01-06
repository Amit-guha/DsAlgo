package com.example.problemsolving.leetcode

fun main() {

}

//unsolved
//Time Limit Exception
/*fun countPalindromicSubsequence(s: String): Int {
    val palindromes = mutableSetOf<String>()
    val leftSite = mutableSetOf<Char>()

    for (i in 1 until s.length - 1) {
        leftSite.add(s[i - 1])
        val rightSite = mutableSetOf<Char>()
        for (j in i + 1 until s.length) {
            if (s[j] in leftSite) {
                palindromes.add(s[j].toString() + s[i] + s[j])
            }
            rightSite.add(s[j])
        }
    }
    return palindromes.size
}*/
