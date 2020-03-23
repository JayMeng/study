package com.jay.datastructure.linkedlist;

/**
 * @author jay
 * @create 2020-03-18 16:23
 **/

public class Josephu {
    //  经典的约瑟夫问题（丢手绢）
    //  设定编号为1，2，3 ...n 的 n 个人围坐一圈，约定 编号为 k （1<=k<=n）人从1开始报数，数到 m 的人出列，他的下一位再从1开始，数到 m 的人 又出列
    //  以此类推，知道所有人都出列为止，由此 顺序输出 出列人的 编号
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.init(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countOut(1, 2, 5);

    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    //  初始化一个单向环形链表
    public void init(int num) {
        if (num < 1) {
            System.out.println("num不能为空");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = cur.getNext();
            }
        }
    }

    //  遍历环形链表并打印
    public void show() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.println(cur);
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    //  startNo = 从第几个节点开始，countNum = 数几个 ， nums = 一开始的节点总个数
    //  思路： 考虑到需要出队（删除节点），单向环形链表，删除需要知道待删除节点的前一个节点（helper），设置 cur = cur.next ; helper.next = cur;
    public void countOut(int startNo, int countNum, int nums) {
        if (startNo > nums || first == null || startNo < 1) {
            System.out.println("参数有误");
            return;
        }
        //  1：先找到链表的最后一个节点 helper,需要找个辅助指针帮助实现出队操作
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //  2: 将first,helper 同时后移 startNo-1 位，
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (first == helper) {
                System.out.println("最后一个节点:" + first);
                break;
            }
            //  3:  将first,helper 同时后移 countNum-1 位，此时first指向的节点就是待出队的节点，（执行删除操作）
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出队的节点是：" + first);
            first = first.getNext();
            helper.setNext(first);
        }
    }
}


class Boy {
    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}