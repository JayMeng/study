package com.jay.datastructure.tree.binarysorttree;

/**
 * @author jay
 * @create 2020-03-30 10:46
 **/

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        //  二叉排序数
    }
}


class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (null == root) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void middleSort() {
        if (null == root) {
            System.out.println("二叉树为空");
            return;
        } else {
            root.middleSort();
        }
    }

    public Node search(Node node) {
        if (null == root) {
            return null;
        } else {
            return root.search(node);
        }
    }

    public Node searchParent(Node node) {
        if (null == root) {
            return null;
        } else {
            return root.searchParent(node);
        }
    }

    public void delNode(Node node) {
        if (root == null) {
            return;
        } else {
            //  1：找到待删除节点
            Node target = root.search(node);
            //  未找到
            if (null == target) {
                return;
            }
            //  如果发现当前二叉排序树只有一个根节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = root.searchParent(node);
            //  2：判断待删除节点是哪一种情形，叶子节点/有一棵子树/有2棵子树
            if (target.left == null && target.right == null) {
                if (parent.left == target) {
                    parent.left = null;
                } else if (parent.right == target) {
                    parent.right = null;
                }

            } else if (target.left != null && target.right != null) {//删除有两颗子树的节点
                int min = delRightTreeMin(target.right);
                target.value = min;
            } else {//删除只有一棵子树的节点
                //待删除节点有一个左子节点
                if (target.left != null) {
                    if (parent.left == target) {
                        parent.left = target.left;
                    } else {
                        parent.right = target.left;
                    }
                } else {
                    //待删除节点只有一个右子节点
                    if (parent.left == target) {
                        parent.left = target.right;
                    } else {
                        parent.right = target.right;
                    }
                }
            }
        }
    }


    public int delRightTreeMin(Node node) {
        Node target = node;
        //  一直往右子树的left指，就是右子树的最小值
        while (target.left != null) {
            target = target.left;
        }
        int min = target.value;
        //  删除该叶子节点（最小值的节点）
        delNode(target);
        return min;
    }

}


class Node {
    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //  递归向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void middleSort() {
        if (this.left != null) {
            this.left.middleSort();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleSort();
        }
    }

    //  查找指定节点
    public Node search(Node node) {
        if (this.value == node.value) {
            return this;
        }
        if (node.value < this.value && this.left != null) {
            return this.left.search(node);
        }
        if (node.value >= this.value && this.right != null) {
            return this.right.search(node);
        }
        return null;
    }

    // 查找指定节点的父节点
    public Node searchParent(Node node) {
        if ((this.left != null && this.left.value == node.value) || (this.right != null && this.right.value == node.value)) {
            return this;
        }
        if (node.value < this.value && this.left != null) {
            return this.left.searchParent(node);
        } else if (node.value >= this.value && this.right != null) {
            return this.right.searchParent(node);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}