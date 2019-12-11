package com.hzq.linkedlist;

public class ReOrderList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
//        n1.next.next.next.next = new ListNode(5);

       ListNode slow = n1;
       ListNode fast = n1;
       while (fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       if(fast != null) slow = slow.next;

        /** reverse the second half */
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode.print(prev);
    }

}

