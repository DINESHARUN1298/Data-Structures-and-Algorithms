package dev.dinesh.leetcode.algorithms.twopointers;

public class RemoveNthNodeFromTheEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = dummy, second = dummy;
        for(int index = 1; index <= n+1; index++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second= second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}