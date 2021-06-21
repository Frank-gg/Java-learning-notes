package DemoMultiThread.DemoThreadCommunication;

/*
* 线程通信例子：使用两个线程打印1-100。线程1与线程2交替打印。
*
* 涉及方法：
* wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器；
* notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的线程。
* */

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {

        while (true){

            synchronized (this) {

                notify();

                if(number < 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用wait方法的线程进入阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
