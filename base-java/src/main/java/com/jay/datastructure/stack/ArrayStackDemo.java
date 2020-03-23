package com.jay.datastructure.stack;

/**
 * 使用数组模拟栈
 *
 * @author jay
 * @create 2020-03-19 15:24
 **/

public class ArrayStackDemo {


    public static void main(String[] args) {

    }


}


class ArrayStack {
    //  栈顶
    private int top = -1;

    private int maxSize;

    //  数据
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return -9999;
        }

        int value = stack[top];
        top--;
        return value;
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[top]);
        }
    }
}

