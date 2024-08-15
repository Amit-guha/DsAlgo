package com.example.problemsolving.leetcode

fun main() {
    println(minimumPushes("aabbccddeeffgghhiiiiii"))
}

fun minimumPushes(word: String) : Int {
    var minimumNumberOfPushes = 0
    val charCount = word.toCharArray().groupBy { it }
    val charArrayWithCount = charCount.map { (char, count) -> Pair(char, count.size) }.sortedByDescending { it.second }.toTypedArray()
    charArrayWithCount.forEachIndexed { index, _ ->
       // println("charArrayWithCount[index].first -> ${charArrayWithCount[index].first}" )
       // println("charArrayWithCount[index].second -> ${charArrayWithCount[index].second}" )
        minimumNumberOfPushes += when(index + 1){
            in 1..8 ->{
                1 * charArrayWithCount[index].second
            }

            in 9..16 ->{
                2 * charArrayWithCount[index].second
            }
            in 17..24 ->{
                3 * charArrayWithCount[index].second
            }

            else ->{
                4 * charArrayWithCount[index].second

            }
        }
    }

    return minimumNumberOfPushes

}