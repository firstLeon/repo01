package com.laoli.datastructure.hash;

import java.util.Arrays;

/**
 * 哈希表
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add(new Student(0,"laoli"));
        hashTable.add(new Student(1,"laomi"));
        hashTable.add(new Student(2,"laotang"));
        hashTable.add(new Student(17,"laoli"));
        hashTable.add(new Student(1,"laomi"));
        hashTable.add(new Student(2,"laotang"));
        hashTable.show();
        Student student = hashTable.findByNum(1);
        System.out.println(student);
    }
}

class HashTable{
    private static final int capacity=16;
    private StudentLinked[] studentLinkeds;

    /**
     * 默认构造
     */
    public HashTable() {
        this.studentLinkeds=new StudentLinked[capacity];
        //初始化每个散列数组
        for (int i=0;i<capacity;i++){
            this.studentLinkeds[i]=new StudentLinked();
        }
    }

    /**
     * 添加数据
     * @param student
     */
    public void add(Student student){
        if ((student.getNum() < 0)||Integer.toString(student.getNum()).length()==0){
            System.out.println("编号必须大于等于0且必须要有编号");
            return;
        }
        int hash = hash(student.getNum());
        //添加
        studentLinkeds[hash].add(student);

    }


    public Student findByNum(int num){
        int hash = hash(num);
        Student student = studentLinkeds[hash].findByNum(num);
        return student;
    }

    /**
     * 展示所有链表
     */
    public void show(){
       for (int i=0;i<capacity;i++){
           studentLinkeds[i].show(i+1);
       }
    }

    /**
     * 散列，根据传进来的num决定放在哪个数组
     * @param num
     * @return
     */
    public int hash(int num){
        int hash = num % capacity;
        return hash;
    }
}

class StudentLinked {
    private Student head;

    public void add(Student stu) {
        if (null == head) {
            head = stu;
            return;
        }

        Student temp = head;
        while (true) {
            if (null == temp.getNext()) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(stu);

}

    public void show(int i){
        Student temp=head;
        if (null==head){
            System.out.println("链表"+i+"为空");
            return;
        }
        System.out.print("第" + i + "条链表\t");
        while (temp != null) {
            System.out.print(temp);
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Student findByNum(int num){
        Student temp=head;
        if (null==head){
            return null;
        }

        while (temp!=null){
            if (temp.getNum()==num){
                break;
            }
            temp=temp.getNext();
        }
        return temp;
    }
}

class Student{
    private int num;
    private String name;
    private Student next;

    public Student(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
