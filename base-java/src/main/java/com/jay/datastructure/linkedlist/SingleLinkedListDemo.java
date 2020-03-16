package com.jay.datastructure.linkedlist;

/**
 * @author jay
 * @create 2020-03-16 10:39
 **/

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node = new Node(5, "mj", "mj");
        Node node1 = new Node(8, "yy", "yy");
        Node node2 = new Node(13, "jj", "jj");
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.list();

        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node);
        linkedList.list();
    }
}


class SingleLinkedList {
    private Node head = new Node(0, "", "");

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (null == temp.next) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //  有序添加
    public void addByOrder(Node node) {
        Node temp = head;
        Boolean flag = false;
        while (true) {
            if (null == temp.next) {
                break;
            }
            if (temp.next.no > node.no) {// 判断temp的后一个元素的值与添加值的大小比较
                break;
            } else if (temp.next.no == node.no) {
                flag = true;//  代表有节点包含重复的信息
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("有节点包含重复的信息");
        } else {
            //  插入到链表中，temp的后面
            node.next = temp.next;
            temp.next = node;
        }

    }


    public void update(Node node) {
        if (null == head.next) {
            System.out.println("链表为空");
            return;
        }

        Node temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("未找到数据");
                return;
            } else if (temp.no == node.no) {
                temp.nickName = node.nickName;
                temp.name = node.name;
                System.out.println("修改成功");
                break;
            }
            temp = temp.next;
        }
    }


    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node temp = head.next;
        Boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("未找到数据");
                return;
            } else if (no == temp.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }


    //  获取链表的有效节点个数
    public int size(Node head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        Node temp = head.next;
        while (temp!=null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //  查询单链表的倒数第 k 个节点的信息
    //  思路，由于单链表只能正向遍历，所以倒数第 k 个 = 正数 （size - k） 个数据 ；两者相加 = size
    public Node getIndex(Node head,int index){


    }



}

class Node {
    public int no;

    public String name;

    public String nickName;

    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
