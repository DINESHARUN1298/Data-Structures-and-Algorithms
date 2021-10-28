package dev.dinesh.leetcode.datastructures.linkedlist;

public class ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode preHead = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = preHead;
            preHead = head;
            head = temp;
        }
        return preHead;
    }

}