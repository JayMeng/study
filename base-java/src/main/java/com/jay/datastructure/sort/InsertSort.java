package com.jay.datastructure.sort;

import java.util.Arrays;

/**
 * @author jay
 * @create 2020-03-24 15:59
 **/

public class InsertSort {


    public static void main(String[] args) {
        //  插入排序
        int[] arr = {0, -1, 2, 7, 4};
        sort(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //  出初始化待插入元素的信息
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
}
