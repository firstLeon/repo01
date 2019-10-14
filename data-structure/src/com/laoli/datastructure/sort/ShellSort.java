package com.laoli.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序（缩小增量排序）
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 10, 5, 3, 60, 0,100};
        optimizatShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序（交换位置法,效率低）
     * @param arr
     */
    public static void shellSort(int[] arr){
        int temp=0;
        for (int gap=arr.length/2;gap>0;gap=gap/2){
            //从第一个增量开始
            for (int i=gap;i<arr.length;i++){
                System.out.println("第"+i+"次");
                for (int j=i-gap;j>=0;j-=gap){
                    //System.out.println(j);
                    if (arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }

            }
        }
    }

    /**
     * 希尔排序（移位法）
     * @param arr
     */
    public static void shellSort02(int[] arr){
        int left = 0;// 数组左边界下标
        int right = arr.length - 1;// 数组右边界下标
        int gap=right-left-1;//增量的初始值

        do{

            gap=gap/3+1;//下一个增量值
            for (int i =left+gap; i <=right; i++) {//各子序列交替处理
                if(arr[i]<arr[i-gap]){//向前搜索，每次跳跃gap
                    int temp=arr[i];
                    int j=i-gap;
                    do{
                        arr[j+gap]=arr[j];//后移元素
                        j-=gap;
                    }while(j>=left && temp<arr[j]);//再比较前一个元素
                    arr[j+gap]=temp;  //插入
                }
            }


        }while(gap>1);


    }

    /**
     * 自思考实现
     * @param arr
     */
    public static void shellSort03(int[] arr){
        int temp=0;
        for (int gap=arr.length/2;gap>0;gap=gap/2){
            //多少个分组
            for (int i=0;i<=gap;i++){
                for (int j=i;j<arr.length-gap;j+=gap){
                    if (arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }

    }

    /**
     * 希尔排序（移位法）
     * @param arr
     */
    public static void optimizatShellSort(int[] arr){

        //增量gap,并逐步缩小增量
        for (int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                //j-gap>=0防止数组下标越键
                while (j-gap>=0&&temp<arr[j-gap]){
                    //移动
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                //当退出while循环后，给temp找到插入的位置
                arr[j]=temp;

            }
        }
    }


}
