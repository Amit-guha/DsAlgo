package com.example.problemsolving.leetcode

fun main() {

   // println(isPrefixOfWord(sentence = "i love eating burger", searchWord = "burg"))
    //println(isPrefixOfWord(sentence = "i am tired", searchWord = "you"))
    println(isPrefixOfWord(sentence = "this problem is an easy problem", searchWord = "pro"))
}

fun isPrefixOfWord(sentence: String, searchWord: String): Int {
     sentence.split(" ").forEachIndexed { index, s ->
      if (s.startsWith(searchWord)){
         return index + 1
      }
    }
    return -1
}