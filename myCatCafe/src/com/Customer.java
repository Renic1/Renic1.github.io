package com;
/*
 * @auther Renic.
 * @version 1.0
 */

import java.time.LocalDate;

public class Customer {
    private String name;
    private int times;//想要rua猫的次数
    private LocalDate arriveTime;

    public Customer(String name, int times) {
        if (times <= 0) {//防止撸猫次数有错
            times = 1;
        }
        this.name = name;
        this.times = times;
        this.arriveTime = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getTimes() {
        return times;
    }

    public LocalDate getArriveTime() {
        return arriveTime;
    }

    @Override
    public String toString() {
        return "顾客信息：" +
                "名字:" + name + ' ' +
                "撸猫次数:" + times + ' ' +
                "到店时间:" + arriveTime;
    }

}
