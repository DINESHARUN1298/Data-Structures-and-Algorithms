package dev.dinesh.leetcode.companies.amazon;

import dev.dinesh.leetcode.algorithms.twopointers.MiddleOfTheLinkedList;

public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(-1);
        ListNode ptr = preHead;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry != 0) {
            ListNode carryNode = new ListNode(carry);
            ptr.next = carryNode;
        }
        return preHead.next;
    }

}