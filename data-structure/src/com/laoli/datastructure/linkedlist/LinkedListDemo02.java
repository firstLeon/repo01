package com.laoli.datastructure.linkedlist;

import java.util.Stack;

public class LinkedListDemo02 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(new Node(1,"laoli","17876895321"));

        myLinkedList.add(new Node(2,"laowang","17876895231"));
        myLinkedList.add(new Node(3,"laoma","17876895132"));


        myLinkedList.show();
        /*System.out.println(myLinkedList.getSize(myLinkedList.getHeadNode()));
        Node countdownNode = myLinkedList.getCountdownNode(myLinkedList.getHeadNode(), 2);
        System.out.println(countdownNode);
        Node findNode = myLinkedList.findCountdownNode(myLinkedList.getHeadNode(), 2);
        System.out.println("#############################################################");
        System.out.println(findNode);*/

  /*      System.out.println("反转链表##############################################################");
        Node node = myLinkedList.reverseNode(myLinkedList.getHeadNode());
        myLinkedList.showReverse(node); */
       /* System.out.println("反转链表递归方式##############################################################");
        Node node = myLinkedList.reverseNodeByRecursion(myLinkedList.getHeadNode());
        myLinkedList.showReverse(node);*/
        System.out.println("逆序打印单链表##############################################################");
        myLinkedList.reverseOrderPrint(myLinkedList.getHeadNode());

    }
}

class MyLinkedList{
    private Node headNode=new Node(0,"","");

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public void add(Node node){
        Node temp=headNode;
        if(null==temp.next){
            System.out.println("该链表为空");
        }
        while (true){
            if(null==temp.next){
                break;
            }
            temp=temp.next;
        }
        //添加数据
        temp.next=node;
    }

    /**
     * 获取倒数第k个节点
     * @param node
     * @param k
     * @return
     */
    public Node getCountdownNode(Node node,int k){
        Node temp=node;
        int length=getSize(node);
        //因为从0开始，所以倒数第k个为length-k,例如length=100;k=2;则temp=（100-2）+1,后面加1是因为但i=0时也执行了一次，所以temp为第99的值，即倒数第二的值
        for (int i=0;i<=length-k;i++){
            temp=temp.next;
        }
        //可能将设i的初始值为1更容易理解
        /*for(int i=1;i<=length-k+1;i++){
            temp=temp.next;
        }*/

        return temp;
    }

    /**
     * 获取链表的长度
     */
    public int getSize(Node node){
        Node temp=node;
        int count=0;
        while (true){
            if(null==temp.next){
                break;
            }
            count++;
            temp=temp.next;
        }
        return count;
    }

    /**
     * 查找倒数节点方式二
     * @param node
     * @param k
     * @return
     */
    public Node findCountdownNode(Node node,int k){
        Node previous=node;
        //实际上当前面的节点遍历完后，取值为behind的节点为倒数的节点，即previous指针先走k-1步，behind再走，但previous走完时，behind便是那个节点
       /* for (int i=0;i<(k-1);i++){
            previous=previous.next;
        }*/
        //从1开始便于理解
        for (int i=1;i<k;i++){
            previous=previous.next;
        }
        Node behind=node;
        while(true){
            if(null==previous.next){
                break;
            }
            previous=previous.next;
            behind=behind.next;
        }
        return behind;
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    public Node reverseNode(Node node){
        Node previous=node;
        Node temp=null;
        Node curent=node.next;
        while (curent!=null){
            temp=curent.next;
            //改变指向，此时curent的下一个节点不再指向原来的节点，而是指向到previous上,下一次循环再接上之前的previous节点
            curent.next=previous;
            //这样将curent节点指向到previous
            previous=curent;
            curent=temp;
        }

        /*while (curent!=null){
            //控制循环
            temp=curent.next;
            curent.next=previous;
            previous=curent;
            //遍历
            System.out.println("pre:"+previous);
            curent=temp;
        }*/
        node.next=null;
        return previous;
    }

    /**
     * 使用递归方式反转单链表
     * @param node
     * @return
     */
    public Node reverseNodeByRecursion(Node node){

        //Node temp=node.next;
        //先判断条件是否满足，不满足继续执行
        if (null==node.next){
            return node;

        }
        //递归得到下一个节点，将下一个节点的next指向为上一个节点即完成反转
        //递归法是从最后一个Node开始，在弹栈的过程中将指针顺序置换的。递归是从最后一个先执行
        Node reverseNode=reverseNodeByRecursion(node.next);
        //temp.next=node;

        /*System.out.println("############"+node.next);
        System.out.println(node);*/
        //反转,即将下一个节点指向上一个节
        node.next.next=node;
        //取消原来的指向
        node.next=null;

        return reverseNode;
    }

    /**
     * 逆序打印单链表,利用栈的先进后出
     * @param node
     * @return
     */
    public void reverseOrderPrint(Node node){
        Node curent=node.next;
        Stack<Node> stack = new Stack<>();
        while (curent!=null){
            stack.push(curent);
            curent=curent.next;
        }
     /*   while (true){
            if (null==curent){
                break;
            }
            stack.push(curent);
            curent=curent.next;
        }*/
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public void show(){
        Node temp=headNode.next;

        while (true){
            if(null==temp){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    public void showReverse(Node reverseNode){
        Node temp=reverseNode;

        while (true){
            if(null==temp){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
