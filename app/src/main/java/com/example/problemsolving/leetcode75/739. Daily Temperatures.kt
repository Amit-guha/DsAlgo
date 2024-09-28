package com.example.problemsolving.leetcode75

fun main() {
    //val dailyTemperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    //val dailyTemperatures = intArrayOf(30,40,50,60)
    val dailyTemperatures = intArrayOf(89, 62, 70, 58, 47, 47, 46, 76, 100, 70)
    dailyTemperatures(dailyTemperatures).onEach { println(it) }
}


fun dailyTemperatures(temperatures: IntArray): IntArray {
    val waitingDays = mutableListOf<Int>()
    var count = 0
    for (i in temperatures.indices) {
        if (i == temperatures.size - 1) {
            waitingDays.add(0)
        } else if (temperatures[i] < temperatures[i + 1]) {
            waitingDays.add(1)
        } else {
            for (j in (i + 1) until temperatures.size) {
                if ((temperatures[i] >= temperatures[j]) && (i != temperatures.size - 2)) {
                    if (j == temperatures.lastIndex) {
                        count = 0
                        waitingDays.add(count)
                    } else {
                        count++
                    }
                } else if (temperatures[i] < temperatures[j]) {
                    count++
                    waitingDays.add(count)
                    count = 0
                    break
                } else {
                    waitingDays.add(0)
                    break
                }

            }

        }
    }
    return waitingDays.toIntArray()

}