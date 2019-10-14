package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序算法思想：
 * 把n个待排序的元素看成一个有序表和一个无序表，开始是有序表中只包含一个元素，无序表中包含n-1个元素
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 10, 5, 3, 60, 0};
        insertSort(arr);
    }

    /**
     * 插入排序法
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            int temp=arr[i];
            int insertIndex=i-1;

            while (insertIndex>=0&&temp<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 插入排序法
     * @param arr
     */
    public static void insertSort02(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int temp=arr[i+1];
            int insertIndex=i;

            while (insertIndex>=0&&temp<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;

            }
            arr[insertIndex+1]=temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 插入排序（这种写法多了几次内部循环执行,不建议）
     * @param arr
     */
    public static void insertSort03(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int temp=arr[i+1];
            //当条件不满足temp<arr[j]时令insertIndex=i+1;
            int insertIndex=i+1;
            //System.out.println(temp);
            for (int j=i;j>=0;j--){

                if (temp<arr[j]){
                    arr[j+1]=arr[j];
                    insertIndex=j;

                }

            }

                arr[insertIndex]=temp;


            System.out.println("第"+(i+1)+"轮排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}