package com.example.problemsolving.leetcode

import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    productQueries(15, arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(0, 3)))
    productQueries(2, arrayOf(intArrayOf(0, 0)))
}

fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
    val MOD = 1_000_000_007
    var sum = 0
    val powers = mutableListOf<Int>()
    val answers = mutableListOf<Int>()

    val root = sqrt(n.toDouble())
    var rootRoundedUp = ceil(root).toInt()

    while (rootRoundedUp >=0 ){
        val power = 2.0.pow(rootRoundedUp).toInt()
        if (power == n){
            powers.clear()
            powers.add(power)
            break
        }else if (power >n ){
            rootRoundedUp--
        }else{
            sum += power
            if (sum > n) {
                sum -= power
            }else {
                powers.add(power)
            }
            rootRoundedUp--
        }
    }
    powers.sort()
    println(powers)

    for (query in queries) {
        var product = 1L
        val left = query[0]
        val right = query[1]
        if (left == right) {
            answers.add(powers[left])
        } else {
            for (j in left..right) {
                product = (product * powers[j]) % MOD
            }
            answers.add(product.toInt())
        }
    }


    println(answers)
    return answers.toIntArray()
}


