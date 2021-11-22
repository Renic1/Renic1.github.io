package com;/*
 * @auther Renic.
 * @version 1.0
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements Runnable {
    @Override
    public void run() {
        test();
    }

    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches()) return true;
        else return false;
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入邮箱(判断正确就退出)：");
            if (isEmail(scanner.next())) {
                System.out.println("邮箱格式正确");
                break;
            }
        }
    }
}
