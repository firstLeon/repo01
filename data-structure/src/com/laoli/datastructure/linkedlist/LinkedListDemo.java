package com.laoli.datastructure.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        /*mySingleLinkedList.add(new Node(1,"laoli","17876895321"));
        mySingleLinkedList.add(new Node(2,"laowang","17876895231"));
        mySingleLinkedList.add(new Node(3,"laoma","17876895132"));*/

        mySingleLinkedList.addByOrder(new Node(3,"laoli","17876895321"));
        mySingleLinkedList.addByOrder(new Node(1,"laowang","17876895231"));
        mySingleLinkedList.addByOrder(new Node(2,"laoma","17876895132"));
        mySingleLinkedList.addByOrder(new Node(2,"laoma","17876895132"));
        mySingleLinkedList.show();
        mySingleLinkedList.updateNameByNum(new Node(2,"laoFJAFAJbbaffffffffffffffffffffAAA","17876895132"));
        System.out.println("##############################################################################");
        mySingleLinkedList.show();

        mySingleLinkedList.deleteByNum(2);
        System.out.println("##############################################################################");
        mySingleLinkedList.show();

    }

}

class MySingleLinkedList{
    private Node headNode=new Node(0,"","");

    public void add(Node node){
        Node temp=headNode;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }

        temp.next=node;
    }

    /**
     * 按编号的顺序添加
     * @param node
     */
    public void addByOrder(Node node){
        Node temp=headNode;
        if(null==temp.next){
            System.out.println("该链表为空");
        }
        boolean flag=false;
        while (true){
            if(null==temp.next){
                break;
            }
            if(temp.next.num>node.num){
                break;
            }else if (temp.next.num==node.num){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag){
            System.out.println("链表中已存在编号为"+node.num+"的数据");
        }else {
            //插入数据到链表
            node.next=temp.next;
            temp.next=node;
        }


    }

    /**
     * 根据编号修改信息
     * @param node
     */
    public void updateNameByNum(Node node){
        Node temp=headNode.next;
        boolean flag=false;
        if(null==temp){
            System.out.println("该链表为空");
        }
        while (true){
            if(null==temp){
                System.out.println("链表已遍历完");
                break;
            }
            if(temp.num==node.num){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if(flag){
            temp.name=node.name;
        }else {
            System.out.println("未找到该编号");
        }
    }

    public void deleteByNum(Integer num){
        Node temp=headNode;
        boolean flag=false;
        while (true){
            if(null==temp.next){
                break;
            }
            if(temp.next.num==num){
                flag=true;
                //被删除的节点没有引用指向将被垃圾回收器回收
                Node temp2=temp.next.next;
                temp.next=temp2;
                break;
            }
            temp=temp.next;
        }

        if(!flag){
            System.out.println("不存在该编号的数据");
        }
    }


    public void show(){
        Node temp=headNode.next;
       while(true){
           if(temp==null){
               break;
           }

           System.out.println(temp);
           temp=temp.next;

       }
    }
}

class Node{

    public Integer num;
    public String name;
    public String phone;
    public Node next;

    public Node(Integer num,String name,String phone){
        this.num=num;
        this.name=name;
        this.phone=phone;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
