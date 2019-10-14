package com.laoli.datastructure.lookupAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找算法（注意：查找序列必须为有序序列）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,4,5,6,6,6,6,6,7,8,9};
        int i = binarySearch(arr, 0, arr.length - 1, 1);
        List<Integer> integers = binarySearch02(arr, 0, arr.length - 1, 6);
        System.out.println(i);
        System.out.println(integers);

    }

    /**
     * 二分查找算法（查找序列中第一个符合的值）
     * @param arr   查找的数组（必须有序）
     * @param left  左索引
     * @param right 右索引
     * @param searchVal 查找值
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int searchVal){

        //找到序列的中间索引
        int middle=(left+right)/2;

        //递归头，当left>right时说明未找到有该值
        if (left>right){
            return -1;
        }
        //当searchVal>arr[middle]时说明要查找的值在右边，此时右递归查找
        if (searchVal>arr[middle]){
            return binarySearch(arr,middle+1,right,searchVal);
        }else if (searchVal<arr[middle]){
            return binarySearch(arr,left,middle-1,searchVal);
        }else {//此外当searchVal=arr[middle]时代表找到了
            return middle;
        }
    }

    /**
     * 二分查找算法（查找序列中每一个符合的值）
     * @param arr   查找的数组（必须有序）
     * @param left  左索引
     * @param right 右索引
     * @param searchVal 查找值
     * @return
     */
    public static List<Integer> binarySearch02(int[] arr,int left,int right,int searchVal){
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        if (left>right){
            return new ArrayList<Integer>();
        }
        //找到中间索引
        int middle=(left+right)/2;
        //当searchVal>arr[middle]时说明要查找的值在右边，此时右递归查找
        if(searchVal>arr[middle]){
            return binarySearch02(arr,middle+1,right,searchVal);
        }else if (searchVal<arr[middle]){
            return binarySearch02(arr,left,middle-1,searchVal);
        }else {//此外当searchVal=arr[middle]时代表找到了

            indexs.add(middle);
            //左移
            int temp=middle-1;
            //向middle索引值的左边边扫描，将所有符合的结果放到list中去
            while (true){
                if (temp<0||arr[temp]!=searchVal){
                    break;
                }
                indexs.add(temp);
                temp--;
            }


            temp=middle+1;
            //向middle索引值的右边扫描，将所有符合的结果放到list中去
            while (true){
                if (temp>arr.length||arr[temp]!=searchVal){
                    break;
                }
                indexs.add(temp);
                temp++;
            }

            /*while (temp>=0&&arr[temp]==searchVal){
                indexs.add(temp);
                temp--;
            }
            while (temp < arr.length&&arr[temp]==searchVal) {
                indexs.add(temp);
                temp++;
            }*/
        }
        return indexs;

    }
}
