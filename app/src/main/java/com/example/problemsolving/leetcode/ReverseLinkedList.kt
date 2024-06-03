package com.example.problemsolving.leetcode

class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * struct ListNode {
     *     int val;
     *     ListNode *next;
     *     ListNode() : val(0), next(nullptr) {}
     *     ListNode(int x) : val(x), next(nullptr) {}
     *     ListNode(int x, ListNode *next) : val(x), next(next) {}
     * };
     */


 /*   class Solution {
        ListNode* tempLinkList;
        ListNode* last=new ListNode();
        ListNode* reveresedhead;

        public:
        ListNode* reverseList(ListNode* head) {
            if(head != nullptr){
                reverseList(head ->next);
                tempLinkList = new ListNode();
                if(reveresedhead == nullptr){
                    reveresedhead = tempLinkList;
                }
                tempLinkList->val = head->val;
                tempLinkList->next = nullptr;

                last ->next = tempLinkList;
                last = tempLinkList;

            }
            return reveresedhead;
        }


    };*/
}