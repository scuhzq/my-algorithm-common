package com.hzq.linkedlist;

public class LinkedListFind {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(findByIterator(head).val);
        System.out.println(findByTwoPointer(head).val);
    }

    private static ListNode findByTwoPointer(ListNode head){
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode findByIterator(ListNode head){
        if(head == null) return null;
        int length = 0;
        ListNode result = head;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }

        int i = 1;
        int mid = length / 2 + 1;
        cur = head;
        while (cur != null){
            if(i == mid){
                result = cur;
                break;
            }
            i++;
            cur = cur.next;
        }

        return result;
    }

}
