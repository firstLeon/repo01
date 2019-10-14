package com.laoli.datastructure.stack;

/**
 * 利用栈解决计算器问题
 * 一位数的运算，计算器
 */
public class CalculatorBaseStackDemo {
    public static void main(String[] args) {

        CalculatorBaseStack calculatorBaseStack = new CalculatorBaseStack();
        calculatorBaseStack.calculater("9/3/3-4");
    }
}

class CalculatorBaseStack{
    private int index=0;
    private int oper=0;
    private int num1=0;
    private int num2=0;
    private int result=0;
    char ch=' ';//保存每次扫描的字符
    String LinkNum=""; //拼接多位数
    public void calculater(String expression){
        //保存数字
        StackBaseArray nums = new StackBaseArray(20);
        //保存算术操作符
        StackBaseArray opts = new StackBaseArray(20);

        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            if (opts.isOper(ch)){
                if (opts.isEmpty()){
                    opts.push(ch);

                }else {
                    if(opts.priority(ch)<=opts.priority(opts.lookeNotPop())){
                        num1=nums.pop();
                        num2=nums.pop();


                        result=nums.countResult(num1,num2,opts.pop());
                        //将运算的值保存到栈中
                        nums.push(result);
                        opts.push(ch);

                    }
                    else {
                        opts.push(ch);
                    }
                }
            }else {
                nums.push((ch-48));

            }

            if (index>=expression.length()-1){
                break;
            }

           index++;


        }


        while (true){
            if (opts.isEmpty()){
                break;
            }

            num1=nums.pop();
            num2=nums.pop();
            result=nums.countResult(num1,num2,opts.pop());
            nums.push(result);

        }

        //得出最后的结果
        System.out.printf("%s=%d",expression,nums.lookeNotPop());
    }
}

class StackBaseArray{
    private int maxSize;
    private int top;
    private int [] array;

    public StackBaseArray(int maxSize) {
        this.maxSize = maxSize;
        this.top=-1;
        this.array=new int[maxSize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public void push(int n){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        array[top]=n;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int val=array[top];
        top--;
        return val;

    }

    /**
     * 定义操作符优先级
     * @param oper
     * @return
     */
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 99;
        }
        else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 查看栈顶值，不取出
     * @return
     */
    public int lookeNotPop(){
        return array[top];
    }

    /**
     * 判断是否为运算符
     * @param ch
     * @return
     */
    public boolean isOper(char ch){
        return ch=='*'||ch=='/'||ch=='+'||ch=='-';
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int countResult(int num1,int num2,int oper){
        int result=0;//保存计算结果
        switch(oper){
           case '+':
               result=num1+num2;
               break;
           case '-':
               result=num2-num1;
               break;
           case '*':
               result=num1*num2;
               break;
           case '/':
               result=num2/num1;
               break;
           default:
               break;
        }
        return result;
    }

    public void show(){
        if (isEmpty()){
            return;
        }
        for (int i=top;i>0;i--){
            System.out.println(array[i]);
        }
    }
}
