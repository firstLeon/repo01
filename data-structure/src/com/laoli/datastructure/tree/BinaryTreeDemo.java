package com.laoli.datastructure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(0, "奥丁");
        HeroNode hero = new HeroNode(1, "古一法师");
        HeroNode hero2 = new HeroNode(2, "雷神");
        HeroNode hero3 = new HeroNode(3, "緑巨人");
        HeroNode hero4 = new HeroNode(4, "美队");
        root.setLeft(hero2);
        root.setRight(hero);
        hero2.setLeft(hero4);
        hero2.setRight(hero3);
        binaryTree.addHero(root);
        System.out.println("前序遍历");
        binaryTree.preTravel();
        System.out.println("中序遍历");
        binaryTree.infixTravel();
        System.out.println("后序遍历");
        binaryTree.postTravel();

        System.out.println("前序遍历查找");
        System.out.println(binaryTree.preTravelSearch(1));
        System.out.println("中序遍历查找");
        System.out.println(binaryTree.infixTravelSearch(1));
        System.out.println("后序遍历查找");
        System.out.println(binaryTree.postTravelSearch(1));

        //删除二叉树节点
     /*   binaryTree.delHero(1);
        System.out.println("删除二叉树节点后的二叉树");
        binaryTree.preTravel();*/
        //删除英雄节点，如果英雄节点有左节点，则将英雄左节点上移为父节点，有右节点将该右节点置为左节点的子节点
        binaryTree.delHeroByNum(2);
        System.out.println("删除二叉树节点后的二叉树");
        binaryTree.preTravel();
    }
}

/**
 * 二叉树
 */
class BinaryTree{
    private HeroNode root;

    public BinaryTree() {
    }

    public void addHero(HeroNode heroNode){
        this.root=heroNode;
    }

    /**
     * 前序遍历
     */
    public void preTravel(){
        this.root.preTravel();
    }

    /**
     * 中序遍历
     */
    public void infixTravel(){
        if (this.root!=null) {
            this.root.infixTravel();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后序遍历
     */
    public void postTravel(){
        if (this.root!=null) {
            this.root.postTravel();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 前序遍历查找
     * @param num
     * @return
     */
    public HeroNode preTravelSearch(int num){
        if (this.root!=null){
            return root.preTravelSearch(num);
        }else {
            return null;
        }
    }

    /**
     * 中序遍历查找
     * @param num
     * @return
     */
    public HeroNode infixTravelSearch(int num){
        if (this.root!=null){
            return root.infixTravelSearch(num);
        }else {
            return null;
        }
    }

    /**
     * 后序遍历查找
     * @param num
     * @return
     */
    public HeroNode postTravelSearch(int num){
        if (this.root!=null){
            return root.postTravelSearch(num);
        }else {
            return null;
        }
    }

    /**
     * 根据编号删除英雄
     * @param num
     */
    public void delHero(int num){
        if (this.root!=null){
            if (this.root.getNum()==num){
                this.root=null;
            }else {
                this.root.delHero(num);
            }
        }else {
            System.out.println("该二叉树为空，不能执行删除任务");
        }
    }

    /**
     * 删除英雄节点，如果英雄节点有左节点，则将英雄左节点上移为父节点，有右节点将该右节点置为左节点的子节点
     * @param num
     */
    public void delHeroByNum(int num){
        if (this.root!=null){
            if (this.root.getNum()==num){
                this.root=null;
            }else {
                this.root.delHeroByNum(num);
            }
        }else {
            System.out.println("该二叉树为空，不能执行删除任务");
        }
    }
}

/**
 * 英雄节点
 */
class HeroNode{
    private int num;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    /**
     * 前序遍历
     * @return
     */
    public void preTravel(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preTravel();
        }
        if (this.right!=null){
            this.right.preTravel();
        }
    }

    /**
     * 中序遍历
     */
    public void infixTravel(){
        if (this.left!=null){
            this.left.infixTravel();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixTravel();
        }
    }

    /**
     * 后序遍历
     */
    public void postTravel(){
        if (this.left!=null){
            this.left.postTravel();
        }
        if (this.right!=null){
            this.right.postTravel();
        }
        System.out.println(this);
    }

    /**
     * 前序查找(根据num查找某个节点)
     * @param num
     * @return
     */
    public HeroNode preTravelSearch(int num){
        if (this.num==num){
            return this;
        }
        HeroNode heroNode=null;
        if (this.left!=null){
            //递归查找
            heroNode = this.left.preTravelSearch(num);
        }
        //当null不等于heroNode时代表找到了
        if (null!=heroNode){
            return heroNode;
        }

        if (this.right!=null){
            heroNode = this.right.preTravelSearch(num);
        }
        if (null!=heroNode){
            return heroNode;
        }
        return heroNode;
    }

    /**
     * 中序遍历查找
     * @param num
     * @return
     */
    public HeroNode infixTravelSearch(int num){
        HeroNode heroNode=null;
        if (this.left!=null){
            heroNode = this.left.infixTravelSearch(num);
        }
        if (null!=heroNode){
            return heroNode;
        }
        if (this.num==num){
            return this;
        }

        if (this.right!=null){
            heroNode=this.right.infixTravelSearch(num);
        }
        if (heroNode!=null){
            return heroNode;
        }

        return heroNode;
    }

    /**
     * 后序遍历查找
     * @param num
     * @return
     */
    public HeroNode postTravelSearch(int num){
        HeroNode heroNode=null;
        if (this.left!=null){
            heroNode=this.left.postTravelSearch(num);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.right!=null){
            heroNode=this.right.postTravelSearch(num);
        }
        if (this.num==num){
            return this;
        }
        return heroNode;
    }

    /**
     * 根据num删除该节点
     * @param num
     */
    public void delHero(int num){
        //左子节点
        if (this.left!=null&&this.left.num==num){
            this.left=null;
            return;
        }
        //右子节点
        if (this.right!=null&&this.right.num==num){
            this.right=null;
            return;
        }
        //左子节点递归
        if (this.left!=null){
            this.left.delHero(num);
        }
        //右子节点递归
        if (this.right!=null){
            this.right.delHero(num);
        }
    }

    /**
     * 删除英雄节点，如果英雄节点有左节点，则将英雄左节点上移为父节点，有右节点将该右节点置为左节点的子节点
     * @return
     */
    public void delHeroByNum(int num){
        if (this.left!=null&&this.left.num==num){
            HeroNode hero=this.left;
            if (hero.left!=null){
                this.left=hero.left;
            }else {
                this.left=null;
            }
            if (hero.right!=null){
                this.left.right=hero.right;
            }
            return;

        }

        if (this.right!=null&&this.right.num==num){
            HeroNode temp=this.right;
            if (temp.right!=null){
                this.right=temp.left;
            }else {
                this.right=null;
            }
            if (temp.right!=null){
                this.right.right=temp.right;
            }
            return;
        }

        if (this.left!=null){
            this.left.delHeroByNum(num);
        }
        if (this.right!=null){
            this.right.delHeroByNum(num);
        }
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
