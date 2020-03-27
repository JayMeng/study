package com.jay.datastructure.hashtable;

/**
 * @author jay
 * @create 2020-03-27 15:29
 **/

public class HashTableDemo {
    public static void main(String[] args) {

    }
}

class HashTable {
    private EmpLinkedList[] arr;

    private int maxSize;

    public HashTable(int maxSize) {
        arr = new EmpLinkedList[maxSize];
        this.maxSize = maxSize;
    }

    public void add(Emp emp) {
        //  根据员工id 通过hash运算判断员工应该放到哪条链表里去
        int empLinkedListNo = hashFun(emp.id);
        arr[empLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < arr.length; i++) {
            arr[i].list();
        }
    }

    public int hashFun(int id) {
        return id % maxSize;
    }
}


class EmpLinkedList {
    private Emp head = null;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            } else {
                cur = cur.next;
            }
        }
        cur.next = emp;
    }

    public void list() {
        if (null == head) {
            System.out.println("链表为空");
            return;
        }
        Emp cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}


class Emp {
    public int id;

    public int name;

    public Emp next;

    public Emp(int id, int name) {
        this.id = id;
        this.name = name;
    }
}