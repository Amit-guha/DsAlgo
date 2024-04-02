package com.example.problemsolving.leetcode

fun main() {
    val input = "   fly me   to   the moon  "
    println("size ->${lengthOfLastWord(input)}")
}

fun lengthOfLastWord(s: String): Int {
    val mainString = s.trim()
    return if (mainString.contains(" ")){
        val listOfString = mainString.split(" ")
        listOfString[listOfString.size - 1].length
    }else{
        mainString.length
    }
}