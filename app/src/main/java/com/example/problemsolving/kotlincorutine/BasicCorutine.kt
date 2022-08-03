package com.example.problemsolving.kotlincorutine

import kotlinx.coroutines.*

var totalFunctionCall = 0
fun main() {
    /*GlobalScope.launch {
        println("First One")
        delay(1500L)
        println("Second One")
    }
    println("Outside of Corutine")
    Thread.sleep(2000)*/

/*    runBlocking {
        launch {
            delay(1000)
            println("runblocking execuated")
        }
        GlobalScope.launch {
            delay(500)
            println("GlobalScope execuated")
        }
        coroutineScope {
            launch {
                delay(2000)
                println("coroutineScope execuated")
            }
        }
    }*/

    runBlocking {
        launch(Dispatchers.Unconfined) {
            println("Thread Name : ${Thread.currentThread().name}")
            delay(100L)
            println("Thread Name : ${Thread.currentThread().name}")
        }
    }


    GlobalScope.launch { lastPartOfMessage() }
    GlobalScope.launch { aSimpleMessage() }
    println("Main fuction")
    Thread.sleep(2500)
    println("Thread Sleep Stopped")
    println("How many funciton call : $totalFunctionCall")
}

suspend fun lastPartOfMessage() {
    delay(1800)
    println("First corutine is calling ----")
    totalFunctionCall++
}

suspend fun aSimpleMessage() {
    delay(1500)
    println("Second corutine is calling ----")
    totalFunctionCall++
}