package com.hzq.linkedlist;

/**
 * Created by hzq on 2020-03-26.
 */
public class LinkedRotate {

	public static void main(String[] args) {
		ListNode head = ListNode.create();
		ListNode.print(head);
		ListNode newHead = rotateRight(head, 1);
		System.out.println();
		ListNode.print(newHead);
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k <= 0){
			return head;
		}
		ListNode oldTail = null;
		ListNode oldHead = head;

		//1.一次遍历找到len
		ListNode cur = head;
		int len = 0;
		while(cur != null){
			oldTail = cur;//先赋值
			cur = cur.next;
			len++;
		}

		//2.如果k是len的倍数，则直接返回
		if(k % len == 0) return head;
		k = k % len;

		//3.找到新的head和tail，拼接新链表
		ListNode newHead = null, newTail = null;
		int target = len - k - 1;
		cur = head;
		while(target > 0){
			cur = cur.next;
			target--;
		}
		newTail = cur;
		newHead = cur.next;

		oldTail.next = oldHead;
		newTail.next = null;
		return newHead;
	}

}
