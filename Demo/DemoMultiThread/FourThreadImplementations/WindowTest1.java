package DemoMultiThread.FourThreadImplementations;

/*
例子：创建三个窗口卖票，总票数为100张（Runnable接口）
*/

class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run(){

        while(true){
            synchronized (""){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {

    public static void main(String[] args) {

        Window1 t1 = new Window1();
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t1);

        t2.setName("窗口1");
        t3.setName("窗口2");

        t2.start();
        t3.start();
    }

}
