package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {

        int[] arr={200,122,560,323,423,585,64,70,21};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //用二维数组表示多少个桶以及桶的容量，为最坏情况考虑，将通的容量设为要排序的数组的长度
        int[][] bucket=new int[10][arr.length];
        //用一个一维数组记录每个桶当前数据个数
        int[] bucketElementSize=new int[bucket.length];
        //找出数组中最大的数
        int maxVal=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>maxVal){
                maxVal=arr[i];
            }
        }

        //求出最大的数的长度
        int maxLength=(maxVal+"").length();


        for (int m=0,n=1;m<maxLength;m++,n*=10){

            for (int i=0;i<arr.length;i++) {
                int bucketElement = arr[i] / n % 10;
                bucket[bucketElement][bucketElementSize[bucketElement]] = arr[i];
                bucketElementSize[bucketElement]++;
            }

            int index=0;
            //拷贝桶的数据到原数组
            for (int j=0;j<bucket.length;j++){
                if(bucketElementSize[j]!=0) {
                    for (int k = 0; k < bucketElementSize[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //置空保存桶数量的一维数组
                bucketElementSize[j]=0;
            }



        }

    }
}
