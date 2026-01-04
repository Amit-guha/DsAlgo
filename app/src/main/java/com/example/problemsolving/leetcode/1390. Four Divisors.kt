package com.example.problemsolving.leetcode

fun main() {

}

fun sumFourDivisors(nums: IntArray): Int {
    var totalSum = 0
    for(num in nums){
        var i = 1
        val divisor = mutableListOf<Int>()
        while (i*i <= num){
            if(num % i == 0){
                divisor.add(i)
                if(i != num/i){
                    divisor.add(num/i)
                }
            }
            i++
        }
        if(divisor.size == 4){
            totalSum += divisor.sum()
        }
    }

    return totalSum
}