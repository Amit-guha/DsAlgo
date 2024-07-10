package com.example.problemsolving.leetcode

fun main() {
    val customers = arrayOf(intArrayOf(1, 2), intArrayOf(5, 1), intArrayOf(7, 1),intArrayOf(10, 1))
    println(averageWaitingTime(customers))
}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var totalProcessingTime = 0.0
    var waitingTime = 0.0
    var startTime = 0.0
    var endTime = 0.0
    var averageTime = 0.0

    customers.forEachIndexed { index, child ->
        child.forEachIndexed { i, time ->
                if (i == 0){
                    startTime = time.toDouble()
                }else{
                    endTime = time.toDouble()
                }
        }

        if (totalProcessingTime< startTime) {
            if (startTime + endTime > totalProcessingTime){
                totalProcessingTime = startTime + endTime
            }else{
                totalProcessingTime += endTime
            }
        } else {
            totalProcessingTime += endTime
        }
        println("total Processing time ->${totalProcessingTime}")
        waitingTime = (totalProcessingTime - startTime)
        averageTime+= waitingTime

    }

    return ((averageTime) / (customers.size))

}