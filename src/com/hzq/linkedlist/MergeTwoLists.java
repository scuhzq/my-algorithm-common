package com.hzq.linkedlist;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.create();
        ListNode l2 = ListNode.create();
        ListNode newHead = iteratorMerge(l1, l2);
        ListNode.print(newHead);
    }

    public static ListNode iteratorMerge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakeNode = new ListNode(0);
        ListNode cur = fakeNode;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null){
            cur.next = l1;
        }

        if (l2 != null){
            cur.next = l2;
        }

        return fakeNode.next;
    }

    public static ListNode recursiveMerge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode newHead;
        if(l1.val <= l2.val){
            newHead = l1;
            newHead.next = recursiveMerge(l1.next, l2);
        } else {
            newHead = l2;
            newHead.next = recursiveMerge(l1, l2.next);
        }

        return newHead;
    }
}
