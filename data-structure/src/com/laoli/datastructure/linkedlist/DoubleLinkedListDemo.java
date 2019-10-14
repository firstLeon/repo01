package com.laoli.datastructure.linkedlist;

/**
 * 测试双向链表
 */
public class DoubleLinkedListDemo {


    public static void main(String[] args) {
        DoubleLinkedListNode doubleLinkedListNode = new DoubleLinkedListNode(0,new Student("laoli",""));
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(doubleLinkedListNode);
        doubleLinkedList.add(new DoubleLinkedListNode(1,new Student("laolao","11526222222222")));
        doubleLinkedList.add(new DoubleLinkedListNode(2,new Student("laommafma","81526222222")));
        doubleLinkedList.add(new DoubleLinkedListNode(3,new Student("laojfajfja","8841125551111")));
        doubleLinkedList.show(doubleLinkedList.getDoubleLinkedListNode());
        doubleLinkedList.updateById(new DoubleLinkedListNode(2,new Student("修改后的信息","178555225551")));
        System.out.println("修改信息后的双向链表");
        doubleLinkedList.show(doubleLinkedList.getDoubleLinkedListNode());
        System.out.println("删除后的双向链表");
        doubleLinkedList.deleteById(2);
        doubleLinkedList.show(doubleLinkedList.getDoubleLinkedListNode());
    }
}

class DoubleLinkedList{
    private DoubleLinkedListNode doubleLinkedListNode;

    public DoubleLinkedListNode getDoubleLinkedListNode() {
        return doubleLinkedListNode;
    }

    DoubleLinkedList(DoubleLinkedListNode node){
        this.doubleLinkedListNode=node;
    }

    /**
     * 双向链表添加节点
     * @param node
     */
    public void add(DoubleLinkedListNode node){

        DoubleLinkedListNode temp=doubleLinkedListNode;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);

    }

    /**
     * 根据编号修改信息
     * @param node
     */
    public void updateById(DoubleLinkedListNode node){

        if(null==doubleLinkedListNode.getNext()){
            return;
        }
        DoubleLinkedListNode temp=doubleLinkedListNode;
        while (temp.getNext()!=null){
            if(temp.getId()==node.getId()){
                break;
            }
            temp=temp.getNext();
        }
        temp.setData(node.getData());
    }

    /**
     * 根据id删除节点
     * @param id
     */
    public void deleteById(Integer id){
        if(doubleLinkedListNode.getNext()==null){
            return;
        }
        DoubleLinkedListNode temp=doubleLinkedListNode;
        while (temp.getNext()!=null){
            if(temp.getId()==id){
                break;
            }
            temp=temp.getNext();
        }
        //交换
        temp.getPrev().setNext(temp.getNext());
        if(temp.getNext()!=null){
            temp.getNext().setPrev(temp.getPrev());
        }

    }

    public void show(DoubleLinkedListNode node){
        if (node.getNext()==null){
            return;
        }
        DoubleLinkedListNode temp=node.getNext();
        while (temp!=null){
            System.out.println(temp);
            temp=temp.getNext();
        }
    }
}

class DoubleLinkedListNode{
    private Integer id;
    private Student data;
    private DoubleLinkedListNode prev;
    private DoubleLinkedListNode next;

    public DoubleLinkedListNode(Integer id, Student data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleLinkedListNode{" +
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

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public DoubleLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }
}

class Student{
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
