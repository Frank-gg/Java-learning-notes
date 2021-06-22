package DemoMultiThread.FourThreadImplementations;

/*
例子：创建三个窗口卖票，总票数为100张（Thread类）
*/

class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {

        while(true){
            synchronized(""){
                if(ticket > 0){
                    System.out.println(getName() + "卖票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }

}

public class WindowTest {

    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
