package com.github.lzy.btrace;

import java.util.Random;

/**
 * @author liuzhengyang
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 20000; i++) {
            try {
                Thread.sleep(1000);
                main.invokeMethod("hello" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int invokeMethod(String arg) {
        return new Random().nextInt();
    }
}
