package com.laoli.datastructure.lookupAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 插值查找算法
 */
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,4,5,6,6,6,6,6,7,8,9};
        /*int i = insertValSearch(arr, 0, arr.length - 1, 6);
        System.out.println(i);*/
        List<Integer> list = insertValSearch02(arr, 0, arr.length - 1, 6);
        System.out.println(list);
    }

    /**
     * 插值查找算法（查出一个值）
     * @param arr  要查找的数组
     * @param left 左索引
     * @param right 右索引
     * @param searchVal 查找值
     * @return
     */
    public static int insertValSearch(int[] arr,int left,int right,int searchVal){
        System.out.println("查找查找次数~");
        //递归头
        if(left>right||searchVal<arr[0]||searchVal>arr[arr.length-1]){
            return -1;
        }
        int middle=left+(right-left)*(searchVal-arr[left])/(arr[right]-arr[left]);
        //右递归
        if (searchVal>arr[middle]){
            return insertValSearch(arr,middle+1,right,searchVal);
        }else if(searchVal<arr[middle]){
            //左递归
            return insertValSearch(arr,left,middle-1,searchVal);
        }else {//找到查找的数
            return middle;
        }
    }

    /**
     * 插值查找算法（查多个值放入list中）
     * @param arr  要查找的数组
     * @param left 左索引
     * @param right 右索引
     * @param searchVal 要查找的值
     * @return
     */
    public static List<Integer> insertValSearch02(int[] arr, int left, int right, int searchVal){
        List<Integer> indexs = new ArrayList<Integer>();
        System.out.println("查找查找次数~");
        //递归头
        if(left>right||searchVal<arr[0]||searchVal>arr[arr.length-1]){
            return new ArrayList<Integer>();
        }
        int middle=left+(right-left)*(searchVal-arr[left])/(arr[right]-arr[left]);
        //右递归
        if (searchVal>arr[middle]){
            return insertValSearch02(arr,middle+1,right,searchVal);
        }else if(searchVal<arr[middle]){
            //左递归
            return insertValSearch02(arr,left,middle-1,searchVal);
        }else {//找到查找的数
            indexs.add(middle);
            int index=middle-1;
            //往左边寻找符合的数
            while (index>=0&&arr[index]==searchVal){
                indexs.add(index);
                index--;
            }
            //往右边查找符合的数
            index=middle+1;
            while (index<arr.length&&arr[index]==searchVal){
                indexs.add(index);
                index++;
            }

        }
        return indexs;
    }
}
