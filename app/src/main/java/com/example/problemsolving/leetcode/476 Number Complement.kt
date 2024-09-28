package com.example.problemsolving.leetcode

fun main(args: Array<String>) {
    println(findComplement(12))
}

fun findComplement(num: Int):Int {
    val convertToBinary = Integer.toBinaryString(num)
    var result = ""
    for (element in convertToBinary){
        result += if(element == '0'){
            "1"
        }else{
            "0"
        }
    }
    return (result.toInt(2))
}