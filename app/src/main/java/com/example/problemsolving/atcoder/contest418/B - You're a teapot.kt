package com.example.problemsolving.atcoder.contest418

import java.math.BigDecimal
import kotlin.text.iterator

fun main() {
    val s = readLine()!!.trim()
    var selectedChar: Char? = null
    for (i in 0 until s.length) {
        if (i + 1 < s.length) {
            if (s[i] == s[i + 1]) {
                selectedChar = s[i]
                break
            }
        }
    }

    val startIndex = s.indexOf(selectedChar!!)
    val endIndex: Int = s.lastIndexOf(selectedChar)

    val substring = s.substring(startIndex, endIndex + 1)
    val subStringLength = substring.length
    var count = 0

    for (ch in substring){
        if (ch == selectedChar){
            count ++
        }
    }

  //  println(count)
    if (subStringLength - 2 == 0){
        println(0)
    }else{
        val numerator = BigDecimal(count - 2)
        val denominator = BigDecimal(subStringLength - 2)
        val result = numerator.divide(denominator, 17, BigDecimal.ROUND_HALF_UP)
        println(result)
    }
}