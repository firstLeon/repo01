package com.laoli.datastructure.array;

import java.util.Arrays;

/**
 * 数组的平移
 */
public class TranslatArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 10, 5, 3, 60, 0};
        translatArray(arr,2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组平移一步
     * @param arr
     */
    public static void translatArray(int[] arr){
        //定义一个变量来保存数组最后一个数
        int temp=arr[arr.length-1];
        //从倒数第一位开始循环，逐步递减，将前一个位置的值赋给后一个位置
        for (int i=arr.length-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        //将第一个数赋值
        arr[0]=temp;
    }

    /**
     * 将数组平移k步
     * @param arr
     */
    public static void translatArray(int[] arr,int k){
        for (int j=0;j<k;j++) {
            //定义一个变量来保存数组最后一个数
            int temp = arr[arr.length - 1];
            //从倒数第一位开始循环，逐步递减，将前一个位置的值赋给后一个位置
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            //将第一个数赋值
            arr[0] = temp;
        }
    }
}


