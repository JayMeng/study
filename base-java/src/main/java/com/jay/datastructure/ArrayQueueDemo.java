package com.jay.datastructure;

/**
 * @author jay
 * @create 2020-03-12 14:52
 **/

public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        System.out.println(  arrayQueue.showHeadQueue());
        arrayQueue.getQueue();
        arrayQueue.print();



    }


}

/**
 * 用数组实现的队列，存在一问题，数组只能使用一次，
 * front 会随着取数据而改变
 * rear 会随着加数据而改变
 * 初始默认都为-1
 **/
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    //  存放数据
    private int[] queue;
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1; //  队列头的前一个位置
        rear = -1;  //  指向队列尾的位置,(存放的时索引)
    }
    public Boolean isFull() {
        return maxSize - 1 == front;
    }
    public Boolean isEmpty() {
        return front == rear;
    }
    public void addQueue(int x) {
        if (isFull()) {
            System.out.println("队列满了");
        }
        rear++;//   后移尾部指针，并赋值
        queue[rear] = x;
    }
    //  从队列取出数据
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列空了");
        }
        front++;
        return queue[front];
    }
    public void print() {
        for (int i = front + 1; i < queue.length; i++) {
            System.out.println("queue[" + i + "] = " + queue[i]);
        }
    }
    //  显示头部数据
    public int showHeadQueue() {
        return queue[front + 1];
    }
}
