package com.jay.datastructure.linkedlist;

/**
 * @author jay
 * @create 2020-03-18 15:32
 **/

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node5 = new Node2(5);

        list.addToLast(node2);
        list.addToLast(node3);
        list.addToLast(node5);

        list.del(5);
        list.list();
    }
}

class DoubleLinkedList {

    public DoubleLinkedList() {

    }

    private Node2 head = new Node2(0);

    public void list() {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }

        Node2 cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    //  添加到链表的尾
    public void addToLast(Node2 node2) {
        Node2 cur = head;
        while (true) {
            if (null == cur.next) {
                break;
            }
            cur = cur.next;
        }
        cur.next = node2;
        node2.pre = cur;
    }

    public void del(int no) {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }
        Node2 cur = head.next;
        while (cur != null) {
            if (cur.no == no) {
                if (cur.next != null) {
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                } else {
                    cur.pre.next = null;
                }
                break;
            }
            cur = cur.next;
        }
    }
}


class Node2 {

    public int no;

    public Node2 pre;

    public Node2 next;

    public Node2(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                '}';
    }
}
