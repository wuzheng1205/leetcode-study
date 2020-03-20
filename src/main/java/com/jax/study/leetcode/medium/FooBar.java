package com.jax.study.leetcode.medium;

import java.util.concurrent.TimeUnit;

/**
 * 交替打印FooBar
 *
 * @author wuzheng
 * @date 2020/03/20 14:00
 */
public class FooBar {
    private int n;

    private int flag = 0;
    private int fooCt = 0;
    private int barCt = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        while (fooCt < n) {
            TimeUnit.MILLISECONDS.sleep(1);
            if (flag == 0) {
                printFoo.run();
                fooCt++;
                flag = 1;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        while (barCt < n) {
            TimeUnit.MILLISECONDS.sleep(1);
            if (flag == 1) {
                printBar.run();
                barCt++;
                flag = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final FooBar fooBar = new FooBar(4);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}