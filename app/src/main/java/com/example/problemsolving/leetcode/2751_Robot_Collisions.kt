package com.example.problemsolving.leetcode

import java.util.Stack

fun main() {
     println(survivedRobotsHealths(intArrayOf(5,4,3,2,1),intArrayOf(2,17,9,15,10), "RRRRR"))
    //println(survivedRobotsHealths(intArrayOf(3, 5, 2, 6), intArrayOf(10, 10, 15, 12), "RLRL"))
   // println(survivedRobotsHealths(intArrayOf(1,2,5,6), intArrayOf(10,10,11,11), "RLRL"))
   // println(survivedRobotsHealths(intArrayOf(11, 44, 16), intArrayOf(1, 20, 17), "RLR"))


}

fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {

    val charDirectionArray = directions.toCharArray()
    val orderArray = IntArray(directions.length) { it }

    val combined = positions.indices.map { i ->
        Triple(positions[i], healths[i], charDirectionArray[i])
    }

    val sortCombined = combined.sortedBy { it.first }

    val sortedPositions = sortCombined.map { it.first }
    val sortedHealths = sortCombined.map { it.second }
    val sortedDirections = sortCombined.map { it.third }
    val sortedIndices = orderArray.sortedBy { positions[it] }

    // println(sortedIndices)

    /*println(sortedPositions)
   println(sortedHealths)
   println(sortedDirections)*/

    val robotStack = Stack<Triple<Int, Char, Int>>()
    for (i in sortedPositions.indices) {

        val tempHealth = sortedHealths[i]
        val tempDirection = sortedDirections[i]
        val tempIndex = sortedIndices[i]

        if (robotStack.isNotEmpty()) {
            if (robotStack.peek().second != tempDirection) {
                if ((robotStack.peek().second == 'L') && (tempDirection == 'R')) {
                    robotStack.push(Triple(tempHealth, tempDirection, tempIndex))
                } else if (robotStack.peek().first == tempHealth) {
                    robotStack.pop()
                } else if (robotStack.peek().first > tempHealth) {
                    val tempStackElement = Triple(
                        robotStack.peek().first - 1,
                        robotStack.peek().second,
                        robotStack.peek().third
                    )
                    robotStack.pop()
                    if (robotStack.isNotEmpty()){
                        removeRobotAgain(robotStack, tempStackElement)
                    }else{
                        robotStack.push(tempStackElement)
                    }

                } else {
                    val tempStackElement =
                        Triple(tempHealth - 1, tempDirection, tempIndex)
                    robotStack.pop()
                    if (robotStack.isNotEmpty()){
                        removeRobotAgain(robotStack, tempStackElement)
                    }else{
                        robotStack.push(tempStackElement)
                    }

                }
            } else {
                robotStack.push(Triple(tempHealth, tempDirection, tempIndex))
            }

        } else {
            robotStack.push(Triple(tempHealth, tempDirection, tempIndex))
        }
    }


    val surviveRobotList: MutableList<Triple<Int, Char, Int>> = robotStack.toMutableList()
    return surviveRobotList.sortedBy { it.third }.map { it.first }

}

private fun removeRobotAgain(
    robotStack: Stack<Triple<Int, Char, Int>>,
    tempStackElement: Triple<Int, Char, Int>
) {
    if ((robotStack.peek().second == 'R') && (tempStackElement.second == 'L')) {
        if (robotStack.peek().first == tempStackElement.first){
            robotStack.pop()
        }else if(robotStack.peek().first > tempStackElement.first){
            val newTempStack = Triple(
                robotStack.peek().first - 1,
                robotStack.peek().second,
                robotStack.peek().third
            )
            robotStack.pop()
            if (robotStack.isNotEmpty()){
                removeRobotAgain(robotStack,newTempStack)
            }else{
                robotStack.push(newTempStack)
            }
        }else{
            val newTempStack =
                Triple(tempStackElement.first - 1, tempStackElement.second, tempStackElement.third)
            robotStack.pop()

            if (robotStack.isNotEmpty()){
                removeRobotAgain(robotStack,newTempStack)
            }else{
                robotStack.push(newTempStack)
            }
        }

    } else {
        robotStack.push(tempStackElement)
    }
}

