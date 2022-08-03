package com.example.ds.stack

class stackPrimay(size: Int) {
    val emptyArray = IntArray(size)
    var top = -1
    var capacity = size


    fun isEmpty() = top == -1
    fun isFull() = top == capacity - 1

    fun push(element: Int) {
        if (isFull()) {
            println("Stack is Full")
            return
        } else {
            top++
            emptyArray[top] = element
        }
    }

    fun pop(): Int {
        if (isEmpty()) {
            println("Stack is Empty")
            return -1
        } else {
            val pop = emptyArray[top--]
            println("pop ->$pop")
            return pop
        }
    }

    fun currentSize(): Int = top + 1

    fun peek(): Int {
        if (isEmpty()) {
            println("Stack is Empty")
            return -1
        } else {
            println("Peek ->${emptyArray[top]}")
            return emptyArray[top]
        }
    }

    fun stackPrintln() {
        for (i in 0..top) {
            println("Stack -> ${emptyArray[i]}")
        }
    }
}

fun main(args: Array<String>) {
    val stack = stackPrimay(5)
    stack.push(5)
    stack.push(6)
    stack.push(7)
    stack.stackPrintln()
    stack.pop()

    stack.peek()
    stack.stackPrintln()
}