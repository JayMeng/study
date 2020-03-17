package com.jay.datastructure.queue;

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
        this.maxSize = maxSize; //队列的长度，比实际队列应用空间大1，比如实际new int[10]，其实应该队列只能存放到a[8]，只能放9个元素
        queue = new int[maxSize];
        front = 0;//    此处的front指向队列的第一个元素
        rear = 0;//     指向队列最后一个元素的后一个位置，因此需要队列预留一个空间，所以呢数组最大空间要比实际应用大。
    }

    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    } //    这里需要注意的是队列预留一个空间， 所以实际满的对列是maxsize-1,此时只要判断rear是否在预留位置上

    public Boolean isEmpty() {
        return front == rear;   //front每次取完后+1,rear又代表最后一个元素的后一个位置。相等即代表取完了
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        queue[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return -9999;
        }
        int n = queue[front];
        front = (front + 1) % maxSize;
        return n;
    }

    public void printQueue() {
        for (int i = front; i < front + size(); i++) {
            System.out.println("queue[" + i % maxSize + "] = " + queue[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int showHeadQueue() {
        return queue[front];
    }
}