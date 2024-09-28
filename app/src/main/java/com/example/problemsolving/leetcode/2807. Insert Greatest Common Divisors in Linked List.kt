package com.example.problemsolving.leetcode

fun main() {
  val headNode = (creteLinkedList(totalElements = mutableListOf(7)))
    //printLinkedList(headNode)
 printLinkedList(insertGreatestCommonDivisors(headNode))
}


fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    val currentNode = head
    var currentHead = currentNode
    while (currentHead?.next != null){
        val gcd = findGcd(currentHead.`val`, currentHead.next!!.`val`)
        val newNode = ListNode(gcd)
        newNode.next = currentHead.next
        currentHead.next = newNode
        currentHead = currentHead.next?.next
    }
    return currentNode
}



fun findGcd(num1: Int, num2: Int): Int {
    var n1 = num1
    var n2 = num2
    while (n1 != n2) {
        if (n1 > n2) {
            n1 -= n2
        } else {
            n2 -= n1
        }
    }
    return n1
}