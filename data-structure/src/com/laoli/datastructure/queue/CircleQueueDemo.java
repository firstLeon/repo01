package com.laoli.datastructure.queue;

import java.util.Scanner;

/**
 * 测试环形队列
 */
public class CircleQueueDemo {

    public static void main(String[] args) {

        CircleQueue circleQueue = new CircleQueue(4);
        Scanner scanner = new Scanner(System.in);
        //接收用户输入的字符
        char key=' ';
        boolean loop=true;
        while(loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            //接收字符
            key=scanner.next().charAt(0);
           switch(key){
              case 's':
                  circleQueue.showQueque();
                  break;
              case 'e':
                  System.out.println("退出程序中...");
                  scanner.close();
                  loop=false;
                  break;
              case 'a':
                  int n=scanner.nextInt();
                  circleQueue.addToQueue(n);
                  break;
              case 'g':
                  int value=circleQueue.getFromQueue();
                  System.out.println(value);
                  break;
              case 'h':
                  int head=circleQueue.getHead();
                  System.out.println(head);
                  break;

              default:
                  break;
           }
        }

    }
}

/**
 * 环形队列（先进先出）
 */
class CircleQueue{
    private int maxSize; //数组的长度
    private int front; //front指向队列的第一个元素，也就是说array[front]是队列的第一个元素
    private int rear;  //rear指向队列的最后一个元素，初始值为0；
    int [] array;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array=new int[maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){

        System.out.println("front:"+front);
        System.out.println("(rear+1)%maxSize:"+(rear+1)%maxSize);
        //如（3+1）%4==0,当取出数据时front是从0~3变化的
        return (rear+1)%maxSize==front;
    }

    public void addToQueue(int n){
        if(isFull()){
            throw new RuntimeException("该队列已满");
        }
        array[rear]=n;
        rear=(rear+1) % maxSize;
    }

    public int getFromQueue(){
        if(isEmpty()){
            throw new RuntimeException("该队列为空，不能获取数据");
        }
        int value=array[front];
        System.out.println(front);
        front=(front+1) % maxSize;
        return value;
    }

    public int size(){
        int count=(rear+maxSize-front) % maxSize;
        return count;
    }

    public void showQueque(){
        for (int i=front;i<front+size();i++){
            System.out.println("array["+i%maxSize+"]="+array[i%maxSize]);
        }
    }

    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列数据为空");
        }
        return array[front];
    }
}
