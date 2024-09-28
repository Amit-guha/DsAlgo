package com.example.problemsolving.leetcode

fun main() {
    println(minSteps(1))
}

fun minSteps(n: Int): Int {

    //If the number is Prime number the Summation will be the number itself
    // otherwise modulus  the number from 2 to the number itself
    // 2|10 = 5
    // 5 |3 or 4 != 0
    // 5 % 5 = 0

    var sum = 0
    var x = 2
    var number = n
    while(number >1){
        while (number % x == 0){
            sum += x
            number /= x

        }
        x ++
    }
    return sum
}