package com.jay.datastructure;

/**
 * 用数组实现环形队列（解决数组普通队列的复用问题）
 *
 * @author jay
 * @create 2020-03-13 14:23
 **/

public class CircleArrayQueueDemo {


}


class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;//    此处的front指向队列的第一个元素
        rear = 0;//     此处的rear指向队列最后一个元素的后一个元素（环形队列，初始直接指向头，尾部的下一个就是头）
    }
    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    public Boolean isEmpty() {
        return front == rear;
    }
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        queue[rear] = n;
        rear = (rear + 1 ) % maxSize;
    }
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return -9999;
        }
        int n = queue[front];
        front = (front + 1 ) % maxSize;
        return n;
    }
    public void printQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.println("queue[" + i % maxSize + "] = " + queue[i % maxSize ]);
        }
    }
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    public int showHeadQueue(){
        return queue[front];
    }
}