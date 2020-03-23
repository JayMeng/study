package com.jay.datastructure.queen;

/**
 * 八皇后问题
 *
 * @author jay
 * @create 2020-03-23 14:48
 **/

public class QueenDemo {

    //  定义有多少个皇后
    int max = 8;
    int[] array = new int[max];


    //  问题：国际象棋，8 * 8 的棋盘，每一行放置一个棋子，共8个，且每一个不能攻击到其他棋子，（同一行，同一列，同一斜线）
    public static void main(String[] args) {
        QueenDemo queenDemo = new QueenDemo();
        queenDemo.check(0);
    }


    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    //  判断新下的棋子 和之前的棋子是否会攻击
    public Boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //  输出皇后摆放的位置
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


