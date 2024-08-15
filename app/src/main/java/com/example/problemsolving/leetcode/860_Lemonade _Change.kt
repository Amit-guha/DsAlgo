package com.example.problemsolving.leetcode

fun main() {
   // println(lemonadeChange(intArrayOf(5, 5, 10)))
    //println(lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
   // println(lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
   // println(lemonadeChange(intArrayOf(5, 5, 5, 5, 10, 5, 10, 10, 10, 20)))
   // println(lemonadeChange(intArrayOf(10,10)))
    println(lemonadeChange(intArrayOf(5,5,5,5,20,20,5,5,5,5)))
}

fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0
    //println(bills.sorted().toList())
    bills.forEach {
        when (it) {
            5 -> five++
            10 -> {
                if (five > 0) five-- else return false
                ten++
            }

            20 -> {
                if (five > 0) {
                    if (ten > 0) {
                        ten--
                        five--
                    } else {
                        if (five >= 3) five -= 3 else return false
                    }
                } else {
                    return  false
                }
            }
        }
    }

    return five >=0
}