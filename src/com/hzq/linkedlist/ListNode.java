package com.hzq.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val);
            cur = cur.next;
        }
    }

    public static ListNode create(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }
}
