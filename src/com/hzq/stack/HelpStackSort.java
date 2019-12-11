package com.hzq.stack;

import java.util.Stack;

public class HelpStackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        sortByStack(stack);
        System.out.println(stack);
    }

    public static void sortByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();//help栈底存最大的数
        while (!stack.empty()){
            int cur = stack.pop();//获取栈顶元素，与help栈中元素比较
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);//将cur入栈
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

}
