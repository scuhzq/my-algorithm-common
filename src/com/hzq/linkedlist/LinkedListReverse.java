package com.hzq.linkedlist;

public class LinkedListReverse {

    public static void main(String[] args) {
        ListNode head = ListNode.create();
        ListNode.print(head);
        ListNode newHead = reverseRev(head);
        System.out.println();
        ListNode.print(newHead);
    }

    public static ListNode iteratorRev(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public static ListNode reverseRev(ListNode cur){
        if(cur == null || cur.next == null) return cur;
        ListNode newHead = reverseRev(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return newHead;
    }

}
