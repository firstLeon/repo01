package com.laoli.datastructure.stack;

public class StackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        //arrayStack.show();
        System.out.println("出栈............................");
        System.out.println(arrayStack.pop());
        System.out.println("出栈后................");
        arrayStack.show();
    }
}

class ArrayStack{
    private int maxSize;
    private int top;
    private int [] array;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top=-1;
        this.array=new int[maxSize];
    }
    //判断栈是否空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断栈是否满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //入栈
    public void push(int n){
        if (isFull()){
            System.out.println("栈已满，不能添加数据");
            return;
        }
        top++;
        array[top]=n;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("空栈");
        }
        int value=array[top];
        top--;
        return value;
    }
    //遍历栈
    public void show(){
        for (int i=top;top>=0;top--){
            System.out.println(array[top]);
        }
    }
}
