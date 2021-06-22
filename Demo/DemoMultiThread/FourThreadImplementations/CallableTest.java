package DemoMultiThread.FourThreadImplementations;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
    实现线程的第三种方式：Callable

    如何理解实现callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
    1.Call()可以有返回值的;
    2.Call()可以抛出异常，被外面的操作捕获，获取异常的信息;
    3.Callable是支持泛型的。

*/

//1.创建一个Callable接口的实现类
class Ca implements Callable{
    //2.实现call方法，线程需要执行的操作要在call()方法中声明
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        Ca Call = new Ca();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(Call);
        //5.创建Thread对象，将FutureTask对象作为参数传递，并调用start()方法启动线程
        Thread t = new Thread(futureTask);
        t.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
