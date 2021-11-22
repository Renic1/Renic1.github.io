package com;
/*
 * @auther Renic.
 * @version 1.0
 */

public class BlackCat extends Cat {
    protected double price = 350.00;

    public BlackCat(String name, int age, String sex) {
        super(name, age, sex, 350.00);
    }

    @Override
    public String toString() {
        return "该黑猫信息：" +
                "名字：" + name + ' ' +
                "年龄：" + age + ' ' +
                "性别：" + sex + ' ' +
                "价格：" + price + ' ';
    }
}
