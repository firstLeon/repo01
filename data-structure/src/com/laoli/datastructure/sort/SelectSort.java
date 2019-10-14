package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序思想：
 * 第一次从arr[0]~arr[n-1]中选取最小值，然后与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，然后与arr[1]交换
 * 第三次从arr[2]~arr[n-1]中选取最小值，然后与arr[2]交换
 * ......
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，然后与arr[i-1]交换
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，然后与arr[i-2]交换
 * 总共通过n-1次得到一个按排序码从小到大的有序序列
 *
 *
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={2,1,10,5,3,60,0};
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("运行耗时："+(end-start));
    }

    /**
     * 选择排序算法
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            //假定当前i为最小值索引
            int minIndex=i;
            //假定arr[i]为最小值
            int minValue=arr[i];
            //从i+1开始查找与minValue进行比较
            for (int j=i+1;j<arr.length;j++){
                //找出最小值的索引，并把该索引位置的值赋给minValue
                if(arr[j]<minValue){
                    minIndex=j;
                    minValue=arr[j];
                }
            }

            //当minIndex等于当前i的值时代表它已经排序好
            if (minIndex!=i){
                //交换位置
                arr[minIndex]=arr[i];
                arr[i]=minValue;
            }

            System.out.println("第"+(i+1)+"轮排序");
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }
}
