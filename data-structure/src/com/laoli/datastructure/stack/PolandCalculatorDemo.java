package com.laoli.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * 中缀表达式转后缀表达式
 */
public class PolandCalculatorDemo {
    public static void main(String[] args) {
        PolandCalculator polandCalculator = new PolandCalculator();
        String expression="300+4*5-2";
        /*List<String> strings = polandCalculator.converToInfixExpression(expression);
        System.out.println(strings);*/
        List<String> strings02 = polandCalculator.converToInfixExpression02(expression);
        System.out.println(strings02);
        Stack<String> stack = polandCalculator.InfixToSuffixExpression02(strings02);
        List<String> list = polandCalculator.InfixToSuffixExpression(strings02);
        System.out.println(list);
        //计算
        int calculate = polandCalculator.calculate(list);
        System.out.printf("%s=%d",expression,calculate);
    }
}

/**
 * 逆波兰计算器
 */
class  PolandCalculator{

    private int index=0;
    private char ch=' ';
    private String LinkNum="";

    //转换为中缀表达式保存在List集合中
    public List<String> converToInfixExpression(String Expression){
        List<String> infixs=new ArrayList<String>();
        while (true){
            if (index>=Expression.length()){
                break;
            }
            ch=Expression.substring(index,index+1).charAt(0);
            //48~57表示字符0~9
            if (ch<48||ch>57){
                infixs.add(ch+"");
            }else {
               //处理多位数
               LinkNum+=ch;

                if (index==Expression.length()-1){
                    infixs.add(LinkNum);
                }else {
                    char temp=Expression.substring(index+1,index+1+1).charAt(0);
                    if (temp<48||temp>57){
                        infixs.add(LinkNum);
                        //置空
                        LinkNum="";
                    }
                }
            }


            index++;
        }
        return infixs;
    }

    /**
     * 将中缀表达式保存在List中
     * @param expression
     * @return
     */
    public List<String> converToInfixExpression02(String expression){
        List<String> infixs=new ArrayList<String>();
        while (true){
            if(index>=expression.length()){
                break;
            }
            ch=expression.charAt(index);
            if (ch<48||ch>57){
                infixs.add(ch+"");
                index++;
            }else {

                while (index<expression.length()&&expression.charAt(index)>=48&&expression.charAt(index)<=57){
                    LinkNum+=expression.charAt(index);
                    index++;
                }
                infixs.add(LinkNum);
                LinkNum="";
            }

        }
        return infixs;
    }


    /**
     * 中缀表达式转为后缀表达式
     * @param infixExpression
     * @return
     */
    public Stack<String> InfixToSuffixExpression02(List<String> infixExpression){

        Stack<String> nums=new Stack<String>();
        Stack<String> operator = new Stack<>();
        for (String infix:infixExpression){
            if(infix.matches("\\d+")){
                nums.push(infix);
            }else if (infix.equals("(")){
                operator.push(infix);
            }else if (infix.equals(")")){
                while (!operator.peek().equals("(")){
                    nums.push(operator.pop());
                }
                //消除小括号
                operator.pop();
            }else {
                while (operator.size()!=0&&getPriority(infix)<=getPriority(operator.peek())){
                    nums.push(operator.pop());
                }
                operator.push(infix);
            }
            }
        while (operator.size()!=0){
            nums.push(operator.pop());
        }

        return nums;
    }

    /**
     * 中缀表达式转后缀表达式
     * @param infixExpression
     * @return
     */
    public List<String> InfixToSuffixExpression(List<String> infixExpression){

        Stack<String> operator=new Stack<String>();
        List<String> list=new ArrayList<String>();
        for (String infix:infixExpression){
            if(infix.matches("\\d+")){
                list.add(infix);
            }else if (infix.equals("(")){
                operator.push(infix);
            }else if (infix.equals(")")){
                while (!operator.peek().equals("(")){
                   list.add(operator.pop());
                }
                //消除小括号
                operator.pop();
            }else {
                while (operator.size()!=0&&getPriority(infix)<=getPriority(operator.peek())){
                    list.add(operator.pop());
                }
                operator.push(infix);
            }
            }
        while (operator.size()!=0){
            list.add(operator.pop());
        }

        return list;
    }

    /**
     * 计算逆波兰表达式
     * @param list
     * @return
     */
    public int calculate(List<String> list){

        Stack<String> stack=new Stack<String>();
        for (String item:list){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int result=0;
                switch(item){
                   case "+":
                       result=num1+num2;
                       break;
                   case "-":
                       result=num2-num1;
                       break;
                   case "*":
                       result=num1*num2;
                       break;
                   case "/":
                       result=num2/num1;
                       break;
                   default:
                       break;
                }
                stack.push(result+"");


            }

        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 返回优先级
     * @param operator
     * @return
     */
    public int getPriority(String operator){
        int result=0;
        switch(operator){
           case "*":
               result=100;
               break;
            case "/":
                result=100;
                break;
            case "+":
                result=10;
                break;
            case "-":
                result=10;
                break;
           default:
               break;
        }
        return result;
    }

    /**
     * 判断是否为操作符
     * @param oper
     * @return
     */
    public boolean isOperator(int oper){
        return oper=='+'||oper=='-'||oper=='*'||oper=='/';
    }


}
