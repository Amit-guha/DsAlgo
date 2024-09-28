package com.example.problemsolving.leetcode


fun main() {
    val prepareListNode =
        creteLinkedList(totalElements = mutableListOf(1, 2, 3))

    var count = 0
    val k = 5

    var quotient = 0
    var reminder = 0


    var head = prepareListNode
    while (head != null) {
        count++
        head = head.next
    }

    reminder = count % k
    quotient = count / k

    var headNode = prepareListNode
    val listNode = mutableListOf<ListNode>()

    if (quotient == 0){
        for (i in 0 until k){
            if (headNode != null){
               listNode.add(ListNode(headNode.`val`))
                headNode = headNode.next
            } else{
                listNode.add(ListNode(-1))
            }
        }
    }


    


}


/*
fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {

}*/
