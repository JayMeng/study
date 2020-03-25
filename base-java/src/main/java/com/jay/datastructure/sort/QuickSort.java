package com.jay.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author jay
 * @create 2020-03-25 11:05
 **/

public class QuickSort {


    public static void main(String[] args) {
        //  快速排序
        //  对冒泡排序的一种改进，取中间值，比他小的放在左边，比他大的放右边
        int[] arr = {2, 7, 0, -3,-1, 0};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //  中位值
        int pivot = arr[(l + r) / 2];
        int temp;
        //  while循环的目的是把比pivot值小的放左边，比pivot值大的放右边
        while (l < r) {
            //  找到左侧大于等于中位值的元素
            while (arr[l] < pivot) {
                l += 1;
            }
            //  找到右侧小于等于中位值的元素
            while (arr[r] > pivot) {
                r -= 1;
            }
            //  相等时，代表中位值左侧都是比他小的元素，右侧都是比他大的元素，退出本次循环
            if (l >= r) {
                break;
            }
            //  交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 此处是为了结束循环,如果不位移的话会导致取到的元素一致都是等于pivot 的那个元素，如果有值在右侧已经等于pivot了，再次循环，r 指向的还是上次的元素，就会死循环
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //  如果l==r,必须l--,r++;否则下面递归时会导致死循环无法退出
        if (l == r) {
            l++;
            r--;
        }
        //  向左递归
        if (left < r) {
            sort(arr, left, r);
        }
        //  向右递归
        if (right > l) {
            sort(arr, l, right);
        }
    }
}
