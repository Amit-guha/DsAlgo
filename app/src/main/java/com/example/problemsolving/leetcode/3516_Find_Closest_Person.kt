package com.example.problemsolving.leetcode

import kotlin.math.abs

fun main() {
    println(findClosest(x = 2, y = 7,z = 4))
}

fun findClosest(x: Int, y: Int, z: Int): Int {
    val xDistanceToZ = abs(x - z)
    val yDistanceToZ = abs(y - z)

    return if (xDistanceToZ == yDistanceToZ) {
        0
    } else if (xDistanceToZ < yDistanceToZ) {
        1
    } else 2
}