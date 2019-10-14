package com.laoli.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr={2,1,10,5,3,60,80};
        //sort(arr);
        //optimizatSort(arr);
        optimizatSort02(arr);
    }

    /**
     * 冒泡排序(从小到大排序)
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        int temp=0;  //定义一个临时变量用于暂时保存交换的值
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1;j++){
                //排序
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"轮排序");
            System.out.println(Arrays.toString(arr));

        }
        return arr;
    }

    /**
     * 冒泡排序优化
     * @param arr
     * @return
     */
    public static int[] optimizatSort(int[] arr){
        int temp=0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"轮排序");
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 冒泡优化
     * @param arr
     * @return
     */
    public static int[] optimizatSort02(int[] arr){
        int temp=0;
        boolean flag=false;  //设置标识为，当一轮未发生排序时证明已经排序完成
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }

            System.out.println("第"+(i+1)+"轮排序");
            System.out.println(Arrays.toString(arr));

            //排序完成，退出循环
            if (!flag){
                break;
            }else {
                //一轮发生排序后将标示位重新置为false,在新一轮中在判断
                flag=false;
            }
        }
        return arr;
    }
}
