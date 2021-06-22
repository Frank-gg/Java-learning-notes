package DemoMultiThread.DemoThreadCommunication;

/*
    线程通信例题：生产者面包问题
*/

class Shop {
    private int bread = 0;
    /**
     * 生产面包
     */
    public synchronized void produceBread() {
        if (bread < 10) {
            bread++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + bread + "个面包");
            notify(); // 唤醒消费者线程
        } else {
            try {
                wait(); // 告诉生产者等待一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费面包
     */
    public synchronized void consumeBread() {
        if (bread > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + bread + "个面包");
            bread--;
            notify(); // 唤醒生产者线程
        } else {
            try {
                wait(); // 告诉消费者等待一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer2 extends Thread {
    private Shop shop;

    public Producer2(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产面包.....");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.produceBread();
        }
    }
}

class Consumer2 extends Thread {
    private Shop shop;
    public Consumer2(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费面包.....");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.consumeBread();
        }
    }
}

public class ProductTest2 {

    public static void main(String[] args) {
        // 创建商店对象
        Shop shop = new Shop();
        // 创建生产者对象，把商店对象作为构造方法参数传入生产者对象中
        Producer2 p1 = new Producer2(shop);
        p1.setName("生产者");
        // 创建消费者对象，把商店对象作为构造方法参数传入消费者对象中
        Consumer2 c1 = new Consumer2(shop);
        c1.setName("消费者");

        p1.start();
        c1.start();
    }
}
