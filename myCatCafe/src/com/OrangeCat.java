package com;/*
 * @auther Renic.
 * @version 1.0
 */

public class OrangeCat extends Cat {
    private boolean isFat;
    protected double price = 200.00;

    public OrangeCat(String name, int age, String sex, boolean isFat) {
        super(name, age, sex, 200.00);
        this.isFat = isFat;
    }

    @Override
    public String toString() {
        return "该橘猫信息：" +
                "名字：" + name + ' ' +
                "年龄：" + age + ' ' +
                "性别：" + sex + ' ' +
                "价格：" + price + ' ' +
                "是否Fat：" + isFat;
    }
}
