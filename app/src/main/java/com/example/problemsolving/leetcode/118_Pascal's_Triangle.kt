package com.example.problemsolving.leetcode

fun main() {
 println(generate(5))
}

/*
1
1,1
1,2,1
1,3,3,1
 */
fun generate(numRows: Int): MutableList<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0 until numRows) {
        val currentList = mutableListOf<Int>()
        currentList.add(1)
        if (i != 0) {
            val prevList= result[i - 1]
            for (j in 0 until prevList.size) {
                if (j + 1 < prevList.size) currentList.add(prevList[j] + prevList[j + 1])

            }
            currentList.add(1)
        }
        result.add(currentList)
    }

  return result
}