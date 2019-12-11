package com.hzq.stack;

import java.util.Stack;

public class TwoStackQueue {

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private Stack<Integer> masterStack;
    private Stack<Integer> slaveStack;

    public TwoStackQueue(){
        this.masterStack = new Stack<>();
        this.slaveStack = new Stack<>();
    }

    public void add(int item){
        if(masterStack.isEmpty()){
            masterStack.push(item);
        } else {
            //先把元素全部移动到slave
            while (!masterStack.empty()){
                slaveStack.push(masterStack.pop());
            }
            masterStack.push(item);//放入节点
            while (!slaveStack.isEmpty()){
                masterStack.push(slaveStack.pop());
            }
        }
    }

    public Integer remove(){
        return masterStack.pop();
    }
}
