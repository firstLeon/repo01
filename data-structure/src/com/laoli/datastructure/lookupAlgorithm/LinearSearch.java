package com.laoli.datastructure.lookupAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 线性查找算法
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={200,122,560,70,323,423,585,64,70,21};
        /*int i = linearSearch(arr, 70);
        System.out.println(i);*/
        List<Integer> integers = linearSearch02(arr, 70);
        System.out.println(integers);
    }

    /**
     * 线性查找算法（查找第一个符合的值）
     * @param arr   查找数组
     * @param searchValue 查找值
     * @return
     */
    public static int linearSearch(int[] arr,int searchValue){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==searchValue){
                return i;
            }
        }

        return -1;
    }

    /**
     * 线性查找算法（查找所有符合的值）
     * @param arr  查找数组
     * @param searchValue 查找值
     * @return
     */
    public static List<Integer> linearSearch02(int[] arr, int searchValue){
        List<Integer> indexs = new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++){
            if (arr[i]==searchValue){
                indexs.add(i);
            }
        }

        return indexs;
    }

}
