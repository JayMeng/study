package com.jay.datastructure.sort;

import java.util.Arrays;

/**
 * @author jay
 * @create 2020-03-24 14:53
 **/

public class BubbleSort {

    //  交换排序： 冒泡排序 + 快速排序
    public static void main(String[] args) {
        //  冒泡排序,时间复杂度 O(n^2)
        int arr[] = {0, -1, 2, 3, 4};
        Integer temp = null;
        for (int i = 0; i < arr.length - 1; i++) {
            //  标识未发生重新排序,优化
            Boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
