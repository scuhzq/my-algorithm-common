package com.hzq.linkedlist;

public class TestRevMN {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        ListNode.print(n1);
        System.out.println();
        ListNode.print(reverseBetween(n1, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m >= n) return head;
        ListNode cur = head;
        //1.遍历找len
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        //2.找到prevStart、start、end、nextEnd
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        ListNode prevStart = dummy;
        ListNode nextEnd = null;
        ListNode start = null;
        ListNode end = null;
        int i = 0;
        while(cur != null && i <= n+1){
            if(i + 1 == m) prevStart = cur;
            if(i - 1 == n) nextEnd = cur;
            if(i == m) start = cur;
            if(i == n) end = cur;
            cur = cur.next;
            i++;
        }
        //3.从start -> end 翻转，返回新的newHead
        ListNode newHead = reverseMN(start, end);
        prevStart.next = newHead;
        start.next = nextEnd;

        return dummy.next;
    }

    //从start -> end 反转链表，返回newHead
    public static ListNode reverseMN(ListNode start, ListNode end){
        ListNode cur = start;
        ListNode prev = null;
        ListNode target = end.next;
        while(cur != target){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
