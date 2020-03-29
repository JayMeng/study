package com.jay.datastructure;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: 1029685278@qq.com
 * @Date: 2020-03-24 20:56
 **/
public class Sort {

    public static void main(String[] args) {
        int[] arr = {0, -2, 5, 3, 1};
        bubble(arr);
        select(arr);
        insert(arr);
    }

    //  冒泡排序
    public static void bubble(int[] arr) {
        Integer temp = null;
        for (int i = 0; i < arr.length - 1; i++) {
            Boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                System.out.println("flag is true");
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //  选择排序,依次遍历，将最小的元素放在a[0];再从第二个开始遍历并取出最小的放在a[1]
    public static void select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //  交换
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    //  插入排序，将所有元素分到两个表，一个为有序表，另一个为无序表
    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertVal = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
}
