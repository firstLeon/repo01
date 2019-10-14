package com.laoli.datastructure.linkedlist;

public class CircleSingleLinkedListDemo02 {

    public static void main(String[] args) {

        CircleSingleLinkedList02 circleSingleLinkedList02 = new CircleSingleLinkedList02();
        circleSingleLinkedList02.add(5);
        circleSingleLinkedList02.show(circleSingleLinkedList02.getGirlNode());
        circleSingleLinkedList02.countGirl(1,2);
    }
}

class CircleSingleLinkedList02{
    private GirlNode girlNode=null;


    /**
     * 添加数据到环形链表中去
     * @param num
     */
    public void add(int num){
        if(num<1){
            return;
        }

        //辅助指针
        GirlNode currentGirl=null;
        for (int i=1;i<=num;i++){
            GirlNode girl=new GirlNode(i);
            if (i == 1) {
                girlNode=girl;
                girlNode.setNext(girlNode);
                //为辅助指针赋初始节点
                currentGirl=girlNode;
            }else {
                //用辅助指针避免原链表断链
                currentGirl.setNext(girl);
                //添加后指向头节点
                girl.setNext(girlNode);
                //指针往后移动
                currentGirl=girl;

            }

        }


    }

    public void countGirl(int k,int m){

        if(k<0){
            return;
        }
        GirlNode helper=girlNode;
        //找到最后的节点赋值给helper
        while (true){
            if (helper.getNext()==girlNode){
                break;
            }
            helper=helper.getNext();
        }

        //girlNode指针和helper指针先走k-1步，找到初始位置
        for (int i=1;i<k;i++){
            girlNode=girlNode.getNext();
            helper=helper.getNext();
        }

        while (true){
            if (helper==girlNode){
                break;
                }
            for (int i=1;i<m;i++){
                girlNode=girlNode.getNext();
                helper=helper.getNext();

            }

            System.out.println("女孩出圈："+girlNode);
            girlNode=girlNode.getNext();
            helper.setNext(girlNode);
            }
        System.out.println("最后的女孩"+girlNode);

    }


    /**
     * 遍历链表
     * @param girl
     */
    public void show(GirlNode girl){
        if (girl.getNext()==girlNode){
            return;
        }

        while (true){
            System.out.println(girl);
            if(girl.getNext()==girlNode){
                break;
            }
            girl=girl.getNext();
        }

    }

    public GirlNode getGirlNode() {
        return girlNode;
    }

    public void setGirlNode(GirlNode girlNode) {
        this.girlNode = girlNode;
    }
}

class GirlNode{
    private Integer id;
    private GirlNode next;

    public GirlNode(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GirlNode{" +
                "id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GirlNode getNext() {
        return next;
    }

    public void setNext(GirlNode next) {
        this.next = next;
    }
}
