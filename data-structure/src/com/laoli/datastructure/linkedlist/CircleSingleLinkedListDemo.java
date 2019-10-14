package com.laoli.datastructure.linkedlist;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();

        circleSingleLinkedList.add( new CircleSingleNode(1,new Children("xiaohai",2)));
        circleSingleLinkedList.add( new CircleSingleNode(2,new Children("xiaoming",1)));
        circleSingleLinkedList.add( new CircleSingleNode(3,new Children("xiaohong",3)));
        circleSingleLinkedList.add( new CircleSingleNode(4,new Children("xiaohai",5)));
        circleSingleLinkedList.add( new CircleSingleNode(5,new Children("xiaoma",6)));

        circleSingleLinkedList.show(circleSingleLinkedList.getCircleSingleNode());
        System.out.println("约瑟夫问题");
        circleSingleLinkedList.getPopQueue(circleSingleLinkedList.getCircleSingleNode(),1,2);
    }
}

class CircleSingleLinkedList{
    private CircleSingleNode circleSingleNode;

    public void add(CircleSingleNode node){

        if (circleSingleNode==null){
            circleSingleNode=node;

            circleSingleNode.setNext(circleSingleNode);
        }else {
            CircleSingleNode temp = circleSingleNode;
            //当next节点是头节点时证明该节点是单链表的结尾
            while (temp.getNext()!=circleSingleNode){
                temp=temp.getNext();
            }
            temp.setNext(node);
            node.setNext(circleSingleNode);
        }

    }

    /**
     * 约瑟夫问题，丢手绢问题
     * @param node
     * @param m
     * @param k
     */
    public void getPopQueue(CircleSingleNode node,int m,int k){
        int size=size(node);
        if (m<0||m>size){
            return;
        }
        CircleSingleNode start=node;


        System.out.println(size);
        //链表长度有多大，筛选多少次
        for (int e=0;e<size;e++) {

            for (int i = 1; i < m; i++) {
                start = start.getNext();
            }
            CircleSingleNode moveStep = start;
            //因为要移除moveStep节点，所以令i=k-1,实际上要删除的节点是i=k时的节点moveStep.getNext()才是真正找到的节点
            for (int i = 1; i <= k - 1; i++) {
                moveStep = moveStep.getNext();
            }

            System.out.println(moveStep.getNext());
            //删除节点
            moveStep.setNext(moveStep.getNext().getNext());
            start = moveStep.getNext();

        }

    }

    public void show(CircleSingleNode node){
        CircleSingleNode temp=node;
        //使用这种方式变量
        while (true){
            System.out.println(temp);
            if(temp.getNext()==circleSingleNode){
                break;
            }
            temp=temp.getNext();
        }
    }

    public int size(CircleSingleNode node){
        int count=0;
        CircleSingleNode temp=node;
        while (true){
            count++;
            if (temp.getNext()==circleSingleNode){
                break;
            }
            temp=temp.getNext();
        }
        return count;
    }



    public CircleSingleNode getCircleSingleNode() {
        return circleSingleNode;
    }

    public void setCircleSingleNode(CircleSingleNode circleSingleNode) {
        this.circleSingleNode = circleSingleNode;
    }
}

class CircleSingleNode{
    private Integer id;
    private Children data;
    private CircleSingleNode next;

    public CircleSingleNode(Integer id, Children data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CircleSingleNode{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Children getData() {
        return data;
    }

    public void setData(Children data) {
        this.data = data;
    }

    public CircleSingleNode getNext() {
        return next;
    }

    public void setNext(CircleSingleNode next) {
        this.next = next;
    }
}

class Children{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
