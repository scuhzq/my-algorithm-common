package com.hzq.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class MergeKList {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);
        lists[0] = n1;
        lists[1] = n2;
        lists[2] = n3;

        ListNode.print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0) return null;
        int size = lists.length;
        if(size == 1) return lists[0];

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        List<ListNode> curs = new LinkedList<>();
        //1.初始化curs列表
        for(int i = 0; i < size; i++){
            ListNode temp = lists[i];
            curs.add(temp);
        }

        //2.处理curs列表
        while(curs.size() > 1){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < curs.size(); i++){
                ListNode temp = curs.get(i);
                if(temp.val < min){
                    min = temp.val;
                    minIndex = i;
                }
            }
            ListNode minNode = curs.get(minIndex);
            cur.next = new ListNode(minNode.val);
            cur = cur.next;
            minNode = minNode.next;
            curs.set(minIndex, minNode);
            if(minNode == null){
                curs.remove(minIndex);
            }
        }

        //3.处理curs.get(0)
        cur.next = curs.get(0);

        return dummy.next;
    }

}
