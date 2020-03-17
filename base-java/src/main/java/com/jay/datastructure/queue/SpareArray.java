package com.jay.datastructure.queue;

/**
 * 洗漱数组与普通数组的转换
 *
 * @author jay
 * @create 2020-03-12 11:22
 **/

public class SpareArray {

    public static void main(String[] args) {
        int[][] array = new int[4][5];
        array[1][2] = 1;
        array[2][3] = 2;
        normal2sparse(array);
    }

    //  普通二维数组 转 稀疏数组并输出
    public static void normal2sparse(int[][] array) {
        print(array);
        int sum = 0;
        for (int[] row : array) {
            for (int value : row) {
                if (0 != value) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (0 != array[i][j]) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        print(sparseArray);
        sparse2normal(sparseArray);
    }

    public static void sparse2normal(int[][] sparse) {
        int[][] array = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            for (int j = 0; j < 3; j++) {
                array[sparse[i][0]][sparse[i][1]] = sparse[i][2];
            }
        }
        print(array);
    }


    //  数组打印
    public static void print(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + "  ");
            }
            System.out.println();
        }
    }
}
