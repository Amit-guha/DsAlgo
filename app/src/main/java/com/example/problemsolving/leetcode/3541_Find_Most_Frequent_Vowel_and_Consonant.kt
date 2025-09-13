package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(maxFreqSum("aeiaeia"))
}

@RequiresApi(Build.VERSION_CODES.N)
fun maxFreqSum(s: String): Int {
    val vowelHashMap = HashMap<Char, Int>()
    val consonantsHashMap = HashMap<Char, Int>()

    for (char in s) {
        if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u') {
            vowelHashMap[char] = vowelHashMap.getOrDefault(char, 0) + 1
        } else {
            consonantsHashMap[char] = consonantsHashMap.getOrDefault(char, 0) + 1
        }
    }

    val vowelMax = if (vowelHashMap.isEmpty()) 0 else vowelHashMap.maxOf { it.value }
    val consonantsMax = if (consonantsHashMap.isEmpty()) 0 else consonantsHashMap.maxOf { it.value }

    return vowelMax + consonantsMax

}