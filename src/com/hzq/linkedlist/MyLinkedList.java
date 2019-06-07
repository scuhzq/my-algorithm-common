package com.hzq.linkedlist;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(-1, 0);
        myLinkedList.get(0);
        myLinkedList.deleteAtIndex(-1);
    }

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(head == null || index < 0) return -1;
        int i = 0;
        Node cur = head;
        while(cur != null){
            if(i == index){
                return cur.val;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0) return;
        if(head == null){
            if(index == 0){
                head = new Node(val);
            }
            return;
        }
        int i = 0;
        if(i == index){
            Node newHead = new Node(val);
            newHead.next = head;
            head = newHead;
            return;
        }
        Node cur = head;
        while(cur != null){
            if((i + 1) == index){
                Node temp = new Node(val);
                temp.next = cur.next;
                cur.next = temp;
                return;
            }
            i++;
            cur = cur.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || head == null){
            return;
        }
        Node cur = head;
        int i = 0;
        if(index == 0){
            head = head.next;
            return;
        }
        while(cur != null && cur.next != null){
            if((i+1) == index){
                cur.next = cur.next.next;
                return;
            }
            i++;
            cur = cur.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
