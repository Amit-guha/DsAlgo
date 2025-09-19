package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

//Unsolved
class TaskManager(tasks: List<List<Int>>) {
    val hashMap = HashMap<Int, List<Int>>()

    init {
        hashMap.put(101, listOf(1, 10))
        hashMap.put(102, listOf(2, 20))
        hashMap.put(103, listOf(3, 15))
    }

    //[userId, taskId, priority]
    fun add(userId: Int, taskId: Int, priority: Int) {
        hashMap.put(taskId, listOf(userId, priority))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun edit(taskId: Int, newPriority: Int) {
        if (hashMap.containsKey(taskId)){
            hashMap.replace(taskId, listOf(hashMap[taskId]!![0], newPriority))
        }

    }

    fun rmv(taskId: Int) {
        if (hashMap.containsKey(taskId)) {
            hashMap.remove(taskId)
        }
    }

    fun execTop(): Int {
        var topTaskId = -1
        var topUserId = -1
        var topPriority = Int.MIN_VALUE

        for ((taskId, value) in hashMap) {
            val userId = value[0]
            val priority = value[1]

            if (priority > topPriority || (priority == topPriority && taskId > topTaskId)) {
                topPriority = priority
                topTaskId = taskId
                topUserId = userId
            }
        }

        if (topTaskId == -1) return -1

        hashMap.remove(topTaskId)
        return topUserId

    }

}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    //[userId, taskId, priority]
    val taskManager =
        TaskManager(listOf(listOf(1, 101, 10), listOf(2, 102, 20), listOf(3, 103, 15)))
    taskManager.add(4, 104, 5)
    taskManager.edit(102, 8)
    println(taskManager.execTop())
    taskManager.rmv(101)
    taskManager.add(5, 105, 15)
    println(taskManager.execTop())
}