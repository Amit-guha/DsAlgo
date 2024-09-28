package com.example.problemsolving.leetcode

var li = ListNode(5)
var v = li.`val`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    val prepareListNode =
        creteLinkedList(totalElements = mutableListOf(1, 2, 3, 4, 5))
    printLinkedList(modifiedList(nums = intArrayOf(1, 2, 3), head = prepareListNode))

}

fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
    val newList = MutableList(100_000 + 1) { false }

    nums.forEachIndexed { index, i ->
        newList[i] = i == nums[index]
    }

    return removeElement(head, newList)
}

fun printLinkedList(head: ListNode?) {
    var currentNode = head
    while (currentNode != null) {
        println(currentNode.`val`)
        currentNode = currentNode.next
    }
}


fun removeElement(head: ListNode?, newList: MutableList<Boolean>): ListNode? {
    if (head == null) return null

    // Handle the case where the head itself contains the value
    var currentHead = head
    while (currentHead != null && newList[currentHead.`val`]) {
        currentHead = currentHead.next
    }

    var currentNode = currentHead
    var previousNode: ListNode? = null

    while (currentNode != null) {
        if (newList[currentNode.`val`]) {
            previousNode?.next = currentNode.next
        } else {
            previousNode = currentNode
        }
        currentNode = currentNode.next
    }

    return currentHead
}


fun creteLinkedList(totalElements: MutableList<Int>): ListNode? {
    if (totalElements.isEmpty()) return null

    /*  for (element in nums) {
          totalElements.removeAll { it == element }
      }*/

    val head = ListNode(totalElements[0])
    var currentNode = head

    for (i in 1 until totalElements.size) {
        val newNode = ListNode(totalElements[i])
        currentNode.next = newNode
        currentNode = newNode
    }

    return head
}