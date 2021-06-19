package DemoMultiThread;

/*
练习：创建两个分线程，分别遍历100以内的偶数和奇数
*/

class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println("偶数：" + i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println("奇数：" + i);
            }
        }
    }
}

public class ThreadTest2 {

    public static void main(String[] args) {
        /*MyThread2 it = new MyThread2();
        MyThread3 it2 = new MyThread3();
        it.start();
        it2.start();*/

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0){
                        System.out.println("奇数：" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println("偶数：" + i);
                    }
                }
            }
        }.start();
    }
}
