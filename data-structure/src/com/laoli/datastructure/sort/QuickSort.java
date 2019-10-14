package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序算法实现
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 10, 5, 3, 60, 0,100,-1};
        quickSort03(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序（以左边第一个为基准数）
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right) {
        int lef,rig,temp;
        //递归头
        if (left>right){
            return;
        }
        lef=left;
        rig=right;
        int base=arr[left];

        while (lef<rig){
            //先从右边往左边找
            while (arr[rig]>=base&&lef<rig){
                rig--;
            }
            while (arr[lef]<=base&&lef<rig){
                lef++;
            }
            //交换位置
            if (lef<rig){
                temp=arr[lef];
                arr[lef]=arr[rig];
                arr[rig]=temp;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[left]=arr[lef];
        arr[lef]=base;

        //左递归
        quickSort(arr,left,rig-1);
        //右递归
        quickSort(arr,rig+1,right);
    }

    /**
     * 快速排序，以右边第一个为基准数
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort02(int[] arr,int left,int right) {

        int lef, rig, temp;
        if (left > right) {
            return;
        }
        lef = left;
        rig = right;
        //基准值
        int base = arr[right];

        while (lef < rig) {
            while (arr[lef] <= base && lef < rig) {
                lef++;
            }
            while (arr[rig] >= base && lef < rig) {
                rig--;
            }
            //交换位置
            if (lef < rig) {
                temp = arr[lef];
                arr[lef] = arr[rig];
                arr[rig] = temp;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[right] = arr[rig];
        arr[rig] = base;

        //左递归
        quickSort02(arr, left, lef - 1);
        //右递归
        quickSort02(arr, lef + 1, right);
    }

    /**
     * 快速排序（以中轴数为基准数）
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort03(int[] arr,int left,int right){
        int lef,rig,temp;
        lef=left;
        rig=right;
        int base=arr[(left+right)/2];

        while (lef<rig){
            while (arr[lef]<base){
                lef++;
            }
            while (arr[rig]>base){
                rig--;
            }

            if (lef>=rig){
                break;
            }

            if (lef<rig){
                temp=arr[lef];
                arr[lef]=arr[rig];
                arr[rig]=temp;
            }

            if (arr[lef]==base){
                rig--;
            }
            if (arr[rig]==base){
                lef++;
            }
            if (lef==rig){
                lef++;
                rig--;
            }

            if (left<lef){
                quickSort03(arr,left,rig);
            }
            if(right>1){
                quickSort03(arr,lef,right);
            }
        }


    }

}
