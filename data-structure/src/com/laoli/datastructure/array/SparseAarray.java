package com.laoli.datastructure.array;

/**
 * 二维数组与稀疏数组的互相转换
 * 应用场景：棋盘，地图
 */
public class SparseAarray {

    public static void main(String[] args) {
        int twoDimensionArray[][]=new int[11][11];
        //1代表黑棋
        twoDimensionArray[1][1]=1;
        //2.代表蓝棋
        twoDimensionArray[2][2]=2;

        int [][] sparseAarray=converToSparseAarray(twoDimensionArray);
        convertToDimensionArray(sparseAarray);
    }

    /**
     * 二维数组转换成稀疏数组
     * @param twoDimensionArray
     */


    public static int[][] converToSparseAarray(int twoDimensionArray[][]){

        //保存数据个数
        int sum=0;
        for (int i=0;i<twoDimensionArray.length;i++){
            for (int j=0;j<twoDimensionArray[0].length;j++){
                if (twoDimensionArray[i][j]!=0) {
                    sum++;
                }
            }
        }

        //定义一个二维数组
        int sparseArray[][]=new int[sum+1][3];


        //输出原始二维数组
        for (int i=0;i<twoDimensionArray.length;i++){
            for (int j=0;j<twoDimensionArray[0].length;j++){
                System.out.printf("%d\t",twoDimensionArray[i][j]);
            }
            System.out.println();
        }


        //表示第几行的数据
        int count=1;
        /**
         * 填充数据
         */
        for (int i=0;i<twoDimensionArray.length;i++){
            for (int j=0;j<twoDimensionArray[0].length;j++){
                if (twoDimensionArray[i][j]!=0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = twoDimensionArray[i][j];
                    count++;
                }
            }
        }

        //填充第一行的数据
        sparseArray[0][0]=twoDimensionArray.length;
        sparseArray[0][1]=twoDimensionArray[0].length;
        sparseArray[0][2]=sum;

        for (int i=0;i<sparseArray.length;i++){
            for (int j=0;j<sparseArray[0].length;j++){

                    System.out.printf("%d\t", sparseArray[i][j]);

            }
            System.out.println();
        }

        return  sparseArray;
    }

    public static int[][] convertToDimensionArray(int [][] sparseArray){
        int[][] dimensionArray=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){

                int row=sparseArray[i][0];
                int column=sparseArray[i][1];
                dimensionArray[row][column]=sparseArray[i][2];

        }

        for (int i=0;i<dimensionArray.length;i++){
            for (int j=0;j<dimensionArray[0].length;j++){
                System.out.printf("%d\t",dimensionArray[i][j]);
            }
            System.out.println();
        }
        return dimensionArray;
    }
}
