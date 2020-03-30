package com.jay.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jay
 * @create 2020-03-30 9:56
 **/

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        //  数组转换位赫夫曼树（最优二叉树）
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

    }


    public static void createHuffmanTree(int[] arr) {
        List<Hero> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Hero(value));
        }
        while (nodes.size() > 1) {
            //  排序，从小到大
            Collections.sort(nodes);
            //  取出权值最小的节点
            Hero leftHero = nodes.get(0);
            //  取出权值第二小的节点
            Hero rightHero = nodes.get(1);
            //  构建一个新的二叉树
            Hero parent = new Hero(leftHero.value + rightHero.value);
            parent.left = leftHero;
            parent.right = rightHero;
            //  从数组中删除处理过的二叉树
            nodes.remove(leftHero);
            nodes.remove(rightHero);
            //  将parent加入到nodes
            nodes.add(parent);
        }
    }
}

class Hero implements Comparable<Hero> {
    int value;//节点权值

    Hero left;//指向左子节点

    Hero right;//指向右子节点

    public Hero(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Hero o) {
        //  从小到大排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "value=" + value +
                '}';
    }
}
