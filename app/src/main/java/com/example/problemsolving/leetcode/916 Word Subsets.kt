package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
   println( wordSubsets(
       arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
       arrayOf("e", "o")
   ))
}


@RequiresApi(Build.VERSION_CODES.N)
fun wordSubsets(words1: Array<String>, words2: Array<String>): MutableList<String> {
    val hashMap = HashMap<Char, Int>()
    val result = mutableListOf<String>()

    words2.forEach { word ->
        val localCount = HashMap<Char, Int>()
        word.forEach { c ->
            localCount[c] = localCount.getOrDefault(c, 0) + 1
        }

        localCount.forEach { (c, count) ->
            hashMap[c] = maxOf(hashMap.getOrDefault(c, 0), count)
        }

    }

    words1.forEach { word ->
        val wordCount = HashMap<Char,Int>()
        word.forEach {
            wordCount[it] = wordCount.getOrDefault(it,0) + 1
        }

        val isUniversal = hashMap.all { (c, requiredCount) ->
            wordCount.getOrDefault(c, 0) >= requiredCount
        }

        if (isUniversal){
            result.add(word)
        }

    }

    return result
}