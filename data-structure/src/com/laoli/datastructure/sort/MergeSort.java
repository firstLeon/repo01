package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 10, 5, 3, 60, 0,100,-1};
        int[] temp=new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if (left<right){
            int middle=(left+right)/2;  //中间索引
            //向左递归进行分解
            mergeSort(arr,left,middle,temp);
            //向右递归进行分解
            mergeSort(arr,middle+1,right,temp);
            //合并
            merge(arr,left,middle,right,temp);
        }
    }

    /**
     * 归并
     * @param arr    排序的原始数组
     * @param left   左边有序序列的初始索引
     * @param middle 中间索引
     * @param right  右边索引
     * @param temp   中转数组
     */
    public static void merge(int[] arr,int left,int middle,int right,int[] temp){
        //左边有序序列的初始索引
        int lef=left;
        //右边有序序列的初始索引
        int rig=middle+1;
        //表示temp中转数组保存的索引值
        int index=0;

        /**
         * 先把左右两边（有序）的数据按照规则填充到temp数组
         * 直到左右两边的有序序列，有一边处理完为止
         */
        while (lef<=middle&&rig<=right){
            //如果左边的有序序列的当前元素小于等于右边有序序列的当前元素，则将左边的当前元素填充到temp数组，
            if (arr[lef]<=arr[rig]){
                temp[index]=arr[lef];
                index++;
                lef++;
            }else {//反之，将右边有序序列的当前元素填充到temp数组
                temp[index]=arr[rig];
                index++;
                rig++;
            }
        }
        //把剩余数据的一边的数据依次全部填充到temp
        while (lef<=middle){ //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[index]=arr[lef];
            lef++;
            index++;
        }
        while (rig<=right){ //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[index]=arr[rig];
            rig++;
            index++;
        }

        /**
         * 将temp数组的元素拷贝到arr中，注意：并不是每次都拷贝所有
         */
        index=0;   //将中转数组下标重新置为0
        int leftTemp=left;
        while (leftTemp<=right){
            arr[leftTemp]=temp[index];
            leftTemp++;
            index++;
        }
    }
}
