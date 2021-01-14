package com.smart.pattern.callback;

/**
 * @author yangqian
 * @date 2021/1/14
 */
public class CallbackDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("我要休息啦");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我被回调啦");
        });
        thread.start();
    }

}
