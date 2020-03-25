package com.jay.datastructure.sort;

import java.util.Arrays;

/**
 * @author jay
 * @create 2020-03-24 15:28
 **/

public class SelectSort {

    public static void main(String[] args) {
        //  选择排序
        int[] arr = {0, -1, 2, 7, 4};
        sort(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Integer minIndex = i;
            Integer min = arr[i];
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
}
