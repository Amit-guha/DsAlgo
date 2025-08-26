package com.example.problemsolving.leetcode

fun main() {
    println(areaOfMaxDiagonal(dimensions = arrayOf(intArrayOf(9, 3), intArrayOf(8, 6))))
    println(areaOfMaxDiagonal(dimensions = arrayOf(intArrayOf(3, 4), intArrayOf(4, 3))))
}

fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var maxDiagonal = 0
    var maxArea = 0

    for (dimension in dimensions) {
        val length = dimension[0]
        val width = dimension[1]

        val area = length * width
        val diagonal = length * length + width * width

        if (maxDiagonal < diagonal){
            maxDiagonal = diagonal
            maxArea = area
        }else if (maxDiagonal == diagonal){
            maxArea = maxOf(maxArea,area)
        }

    }

   return maxArea

}