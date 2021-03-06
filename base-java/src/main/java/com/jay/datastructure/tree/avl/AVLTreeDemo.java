package com.jay.datastructure.tree.avl;

/**
 * 平衡二叉树
 *
 * @author jay
 * @create 2020-03-30 15:39
 **/

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.middleSort();
        System.out.println(tree.getRoot().height());
        System.out.println(tree.getRoot().left.height());
        System.out.println(tree.getRoot().right.height());
    }
}


class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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

    //  获取当前节点的高度,以该节点为根节点的树高度
    public int height() {
        return Math.max(null == left ? 0 : left.height(), null == right ? 0 : right.height()) + 1;
    }

    //  返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //  左旋
    public void leftRotate() {
        //  创建新的节点，以当前节点的值
        Node newNode = new Node(value);
        //  把新的节点的左子树设为当前节点的左子树
        newNode.left = this.left;
        //  把新的节点的右子树设为当前节点右子树的左节点
        newNode.right = this.right.left;
        //  把当前节点的值替换为右子节点的值
        value = this.right.value;
        //  把当前节点的右子树设置为当前节点右子树的右子树（等价于跳着指下去）
        right = right.right;
        //  把当前节点的左子树设置成新的节点
        left = newNode;
    }

    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
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
        //  当添加完一个节点后，需要判断是否需要左旋（右子树的高度-左子树的高度>1）
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() - right.rightHeight() > 1) {
                //  先对当前节点的右子节点右旋
                right.rightRotate();
                //  左旋
                leftRotate();
            } else {
                //  左旋
                leftRotate();
            }
            //  !!!!这里必须要，不然这边刚刚平衡后，又接着往下走
            return;
        }

        //  左子树高度 - 右子树高度 > 1 ，右旋
        if (leftHeight() - rightHeight() > 1) {
            //  如果左子树的右子树的高度 - 左子树的左子树的高度 > 1 ; 先左旋左子树节点
            if (left != null && left.rightHeight() - left.leftHeight() > 1) {
                //  先对当前节点的左子节点左旋
                left.leftRotate();
                //  再对当前节点右旋
            } else {
                //  直接右旋
                rightRotate();
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
