package com.jay.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author jay
 * @create 2020-03-25 13:50
 **/

public class MergeSort {
    public static void main(String[] args) {
        //  核心思想，先将所有元素拆分到足够小，最后由小到大合并
        //  合并时，依次比较两个有序小的数组，依次比较元素大小，放到新的数组中temp，再将temp 拷贝到 arr
        int arr[] = {3, 1, 4, 6, 2, 9};
        int temp[] = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //  向左递归进行分解
            sort(arr, left, mid, temp);
            //  向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //  合并
            merge(arr, left, mid, right, temp);
        }
    }

    //  合并过程
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;//临时数组的索引
        //  先依次挨个比较两个小的有序数组，并放到临时数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //  把有剩余数据的一边数据依次全部填充到temp数组
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //  将临时数组的元素copy到arr
        //  注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
