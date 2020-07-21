package com.xr.syn;

/**
 * @Description
 * @Date2020/6/2714:42
 * @Author xurui
 */
public class SynchronizedTest implements Runnable {
    private int count = 0;
    private Object object = new Object();
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if("add".equals(name)) {
            this.addCount();
        }else{
            this.decCount();
        }
    }
    private void addCount() {
        synchronized(this){
            for(int i = 0; i < 5;i ++) {
                try {
                    count = count + 1;
                    System.out.println(Thread.currentThread().getName() + "[" + i + "]:" + count );
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void decCount() {
        synchronized(this){
            for(int i = 0; i < 5;i ++) {
                try {
                    count = count - 1;
                    System.out.println(Thread.currentThread().getName() + "[" + i + "]:" + count );
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        Thread thread = new Thread(synchronizedTest,"add");
        Thread thread1 = new Thread(synchronizedTest1,"dec");
        thread.start();
        thread1.start();
    }
}
