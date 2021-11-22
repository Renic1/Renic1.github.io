package com;
/*
 * @auther Renic.
 * @version 1.0
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double balance;
    private ArrayList<Cat> catList = new ArrayList<>(20);
    private ArrayList<Customer> customerList = new ArrayList<>(20);

    public MyCatCafe(double balance) {
        this.balance = balance;
    }

    @Override
    public void buyNewCat(Cat cat) {
        try {
            if (this.balance - cat.price < 0) {
                throw new InsufficientBalanceException(cat.getName());
            } else {
                this.balance -= cat.price;
                catList.add(cat);
                System.out.println("购买成功，" + cat.getName() + "已加入店内");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage() + "因余额不足无法加入店内");
        }

    }

    @Override
    public void serveCustomer(Customer customer) {
        try {
            if (catList.size() == 0) {
                throw new CatNotFoundException("猫咖中暂时没有猫猫可撸");
            } else {
                this.balance += customer.getTimes() * 15;
                customerList.add(customer);
                System.out.println(customer.getName() + "来撸猫了~~~\n" + "被撸猫的信息为:");
                Random random = new Random();
                for (int i = 0; i < customer.getTimes(); i++) {
                    int randNum = random.nextInt(catList.size());
                    System.out.println(catList.get(randNum));
                }
            }
        } catch (CatNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Rest() {
        LocalDate localDate = LocalDate.now();
        double balance1 = 0.0;
        System.out.println("今天已歇业");
        for (int i = 0; i != customerList.size(); i++) {
            if (localDate.equals(customerList.get(i).getArriveTime())) {
                System.out.println(customerList.get(i));
                balance1 += (customerList.get(i).getTimes() * 15);
            }
        }
        System.out.println("本日收入为:" + balance1);
    }
}
