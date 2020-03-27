package com.jay.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jay
 * @create 2020-03-26 10:17
 **/

public class BinarySearch {
    public static void main(String[] args) {
        // 二分查找
        int[] arr = {0, 1, 2, 3, 3, 3, 7, 8, 9};
        System.out.println(search(arr, 0, arr.length, 3));
        System.out.println(search2(arr, 0, arr.length, 3));
    }

    public static int search(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (value < midValue) {
            return search(arr, left, mid - 1, value);
        } else if (value > midValue) {
            return search(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    /**
     * @return int
     * @Author mj
     * @Description 找到所有知道元素的下标
     * @Date 2020/3/27 14:01
     * @Param [arr, left, right, value]
     **/
    public static ArrayList search2(int[] arr, int left, int right, int value) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (value < midValue) {
            return search2(arr, left, mid - 1, value);
        } else if (value > midValue) {
            return search2(arr, mid + 1, right, value);
        } else {
            //  找到第一个相等的元素后，分别向前和向后遍历，
            // 由于数组是有序的，所以只需要判断值是否相等
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return (ArrayList) list;
        }
    }
}
