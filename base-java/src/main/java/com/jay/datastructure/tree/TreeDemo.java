package com.jay.datastructure.tree;

/**
 * @Desc:
 * @Author: 1029685278@qq.com
 * @Date: 2020-03-29 20:27
 **/
public class TreeDemo {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(0);
        tree.setRoot(root);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        tree.getRoot().setLeft(node1);
        tree.getRoot().setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setLeft(node7);
        node3.setRight(node8);
        node2.setLeft(node5);
        node2.setRight(node6);
        node5.setLeft(node9);

//        tree.pre();
//        tree.middle();
        tree.post();
    }
}


class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void pre() {
        root.pre();
    }

    public void middle() {
        root.middle();
    }

    public void post() {
        root.post();
    }
}


class Node {
    private int no;

    private Node left;

    private Node right;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //前序遍历
    public void pre() {
        //  先输出父节点
        System.out.println(this);
        //  递归向左子树前序遍历
        if (this.left != null) {
            this.left.pre();
        }
        //  递归向右子树前序遍历
        if (this.right != null) {
            this.right.pre();
        }
    }

    //  前序遍历查询
    public Node preFind(int no) {
        //  先判断当前结点是否相等
        if (no == this.no) {
            return this;
        }
        Node result = null;
        //  先判断当前结点的左子节点是否为空，不为空则递归查询，找到则返回
        if (this.left != null) {
            result = this.left.preFind(no);
        }
        if (result != null) {
            return result;
        }
        if (this.right != null) {
            result = this.right.preFind(no);
        }
        if (result != null) {
            return result;
        }
        return result;
    }

    //中序遍历
    public void middle() {
        //  递归向左字树中序遍历
        if (this.left != null) {
            this.left.middle();
        }
        //  先输出父节点
        System.out.println(this);
        if (this.right != null) {
            this.right.middle();
        }
    }

    //后序遍历
    public void post() {
        //  递归向左字树后序遍历
        if (this.left != null) {
            this.left.post();
        }
        if (this.right != null) {
            this.right.post();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
