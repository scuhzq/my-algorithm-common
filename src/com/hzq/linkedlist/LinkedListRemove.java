package com.hzq.linkedlist;

import java.util.List;

public class LinkedListRemove {

    public static void main(String[] args) {
        ListNode head = ListNode.create();
        ListNode.print(head);
        System.out.println();
        ListNode.print(recursiveRemove(head, 5));
    }

    public static ListNode recursiveRemove(ListNode cur, int val){
        if(cur == null) return null;
        cur.next = recursiveRemove(cur.next, val);
        if(cur.val == val){
            return cur.next;
        } else {
            return cur;
        }
    }

    public static ListNode iteratorRemove(ListNode head, int val){
        if(head == null) return null;
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode prev = fakeNode;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }

        return fakeNode.next;
    }

}
