package com;
/*
 * @auther Renic.
 * @version 1.0
 */

public class Test {
    public static void main(String[] args) {
        MyCatCafe myCatCafe = new MyCatCafe(1000.0);
        BlackCat blackCat1 = new BlackCat("肥波1", 2, "男");
        BlackCat blackCat2 = new BlackCat("肥波2", 3, "男");
        BlackCat blackCat3 = new BlackCat("肥波3", 4, "女");
        OrangeCat orangeCat1 = new OrangeCat("小飞1", 10, "女", true);
        OrangeCat orangeCat2 = new OrangeCat("小飞2", 10, "女", true);
        OrangeCat orangeCat3 = new OrangeCat("小飞3", 10, "女", false);
        Customer customer1 = new Customer("小林", 1);
        Customer customer2 = new Customer("小李", 2);
        Customer customer3 = new Customer("小王", 3);
        try {
            System.out.println("有客人太早来了，还没有购买猫猫");
            myCatCafe.serveCustomer(customer1);
            System.out.println("======================");
            System.out.println("猫咖进行猫猫的购买业务");
            myCatCafe.buyNewCat(blackCat1);
            myCatCafe.buyNewCat(blackCat2);
            myCatCafe.buyNewCat(blackCat3);
            myCatCafe.buyNewCat(orangeCat1);
            myCatCafe.buyNewCat(orangeCat2);
            myCatCafe.buyNewCat(orangeCat3);
            System.out.println("======================");
            System.out.println("猫咖开业，招待顾客中");
            Customer customer4 = new Customer("小陈", -1);
            myCatCafe.serveCustomer(customer1);
            myCatCafe.serveCustomer(customer2);
            myCatCafe.serveCustomer(customer3);
            myCatCafe.serveCustomer(customer4);
            System.out.println("======================");
            myCatCafe.Rest();
        } catch (CatNotFoundException e) {
            e.printStackTrace();
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
    }
}


