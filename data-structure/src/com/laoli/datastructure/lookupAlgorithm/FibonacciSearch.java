package com.laoli.datastructure.lookupAlgorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 斐波那契查找算法（要求序列必须有序）
 */
public class FibonacciSearch {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7, 9, 9};

      List<Integer> i = fibonacciSearch04(arr, 0, arr.length - 1, 9);
        System.out.println(i);
    }

    /**
     * 斐波那契查找算法实现（他要求开始表中记录的个数为某个斐波那契数小1，即n=Fk-1）
     *
     * @param arr       原数组
     * @param left      左索引
     * @param right     右索引
     * @param searchVal 搜索值
     * @return
     */
    public static int fibonacciSearch(int[] arr, int left, int right, int searchVal) {

        int middle = 0; //存放mid值
        int k = 0;//表示斐波那契分割数值的下标

        //获取到斐波那契数列
        int[] fibonList = fibonList();
        //查找到大于或等于数组长度的fibonList索引
        while (fibonList[k] - 1 < right) {
            k++;
        }

        //拷贝一个数组长度为大于或等于原来数组长度的数组，方便后续操作
        int[] temp = Arrays.copyOf(arr, fibonList[k] - 1);
        //将数组后面空出的的值全部补为原数组最后一个数的值
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }

        while (left <= right) {
            //开始查找索引
            middle = left + fibonList[k - 1] - 1;
            if (searchVal < temp[middle]) {
                right = middle - 1;
                k--;
            } else if (searchVal > temp[middle]) {
                left = middle + 1;
                k -= 2;
            } else {
                if (middle <= right) {
                    return middle;
                } else {
                    return right;
                }
            }

        }
        return -1;
    }


    /**
     * 自己写的斐波那契
     *
     * @param arr
     * @param left
     * @param right
     * @param searchVal
     * @return
     */
    public static int fibonacciSearch02(int[] arr, int left, int right, int searchVal) {

        //定义mid
        int middle = 0;
        //定义斐波那契数列分割的下标
        int k = 0;
        //斐波那契数列
        int[] fibon = fibonList();
        //更加数组的长度找出斐波那契数列的索引
        while (fibon[k] - 1 < arr.length) {
            k++;
        }
        //将原数组的内容拷贝到新数组，新数组的长度为fibon[k]-1
        int[] temp = Arrays.copyOf(arr, fibon[k] - 1);
        //将原数组最后一个数填充到temp数组新增的节点中去
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }
        //循环
        while (left <= right) {
            //初始的middle位置
            middle = left + fibon[k - 1] - 1;
            if (searchVal < temp[middle]) {
                right = middle - 1;
                k--;
            } else if (searchVal > temp[middle]) {
                left = middle + 1;
                k -= 2;
            } else {
                //当middle>=right时说明值是最后一个数，由于数组后面可能有相同的数，所以这时候返回right就可以了
                if (middle >= right) {
                    return right;
                } else {
                    return middle;
                }

            }
        }
        return -1;
    }




    /**
     * 斐波那契(保存所有符合的)
     * @param arr
     * @param left
     * @param right
     * @param searchVal
     * @return
     */
    public static List<Integer> fibonacciSearch04(int[] arr, int left, int right, int searchVal){

        ArrayList<Integer> indexs = new ArrayList<Integer>();
        //定义mid
        int middle=0;
        //定义斐波那契数列分割的下标
        int k=0;
        //斐波那契数列
        int[] fibon = fibonList();
        //更加数组的长度找出斐波那契数列的索引
        while (fibon[k]-1<arr.length){
            k++;
        }
        //将原数组的内容拷贝到新数组，新数组的长度为fibon[k]-1
        int[] temp = Arrays.copyOf(arr, fibon[k] - 1);
        //将原数组最后一个数填充到temp数组新增的节点中去
        for (int i=arr.length;i<temp.length;i++){
            temp[i]=arr[arr.length-1];
        }
        //循环
        while (left<=right){
            //初始的middle位置
            middle=left+fibon[k-1]-1;
            if (searchVal<temp[middle]){
                right=middle-1;
                k--;
            }else if (searchVal>temp[middle]){
                left=middle+1;
                k-=2;
            }else {
                //当middle>=right时说明值是最后一个数，由于数组后面可能有相同的数，所以这时候返回right就可以了
                if (middle>=right){
                    indexs.add(right);
                    //左移
                    int p=right-1;
                    //向middle索引值的左边边扫描，将所有符合的结果放到list中去
                    while (true){
                        if (p<0||temp[p]!=searchVal){
                            break;
                        }
                        indexs.add(p);
                        p--;
                    }
                    return indexs;

                }else {
                    indexs.add(middle);
                    //左移
                    int p=middle-1;
                    //向middle索引值的左边边扫描，将所有符合的结果放到list中去
                    while (true){
                        if (p<0||temp[p]!=searchVal){
                            break;
                        }
                        indexs.add(p);
                        p--;
                    }


                    p=middle+1;
                    //向middle索引值的右边扫描，将所有符合的结果放到list中去
                    while (true){
                        if (p==arr.length-1||temp[p]!=searchVal){
                            break;
                        }
                        indexs.add(p);
                        p++;
                    }
                    return indexs;
                }



            }
        }
        return new ArrayList<Integer>();
    }

    /**
     * 生成斐波那契数列
     * @return
     */
    public static int[] fibonList(){
        int[] f=new int[20];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<f.length;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
}
