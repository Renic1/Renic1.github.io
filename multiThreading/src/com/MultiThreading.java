package com;/*
 * @auther Renic.
 * @version 1.0
 */

public class MultiThreading {
    final static Object obj = new Object();
    public static boolean loop = true;//保证第一个数组先输出
    public static boolean loop1 = false;
    public static boolean loop2 = false;

    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreading();
        multiThreading.run();
        Thread thread2 = new Thread(new Regex());
        thread2.start();
    }

    public void run() {
        int[] arr1 = new int[]{1, 3, 5, 7, 9, 11};
        int[] arr2 = new int[]{2, 4, 6, 8, 10, 12, 14};
        print(arr1, arr2);
    }

    private static void print(int[] arr1, int[] arr2) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                loop = false;//保证第一个数组先输出
                for (int i : arr1) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                        if (i == arr1[arr1.length - 1]) loop1 = true;//一个数组输入完成
                        obj.notify(); //叫醒其他线程，这里就是t2
                        if (!loop1 || !loop2) obj.wait(); //让自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();//输出完成之后解锁

            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i : arr2) {
                    System.out.println(i);
                    try {
                        while (loop) {
                            obj.notify(); //叫醒其他线程，这里就是t2
                            obj.wait(); //让自己阻塞，让出锁
                        }
                        Thread.sleep(100);
                        if (i == arr2[arr2.length - 1]) loop2 = true;//一个数组输入完成

                        obj.notify(); //叫醒其他线程，这里就是t2
                        if (!loop1 || !loop2) obj.wait(); //让自己阻塞，让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





