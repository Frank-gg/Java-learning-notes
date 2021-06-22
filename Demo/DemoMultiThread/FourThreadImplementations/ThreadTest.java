package DemoMultiThread.FourThreadImplementations;

/*
遍历100以内的所有偶数
*/

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建子类对象，调用方法
        MyThread t1 = new MyThread();
        t1.start();
    }
}
