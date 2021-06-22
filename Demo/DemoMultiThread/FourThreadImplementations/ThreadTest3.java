package DemoMultiThread.FourThreadImplementations;

//1.创建Runnable接口实现类
class Test implements Runnable{

    //2.重写run()方法
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println("偶数有：" + i);
            }
        }
    }
}

public class ThreadTest3 {
    public static void main(String[] args){

        //3.创建接口实现类的对象
        Test t1 = new Test();

        //4.将对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t2 = new Thread(t1);

        //5.通过Thread对象调用start()方法
        t2.start();

    }
}
