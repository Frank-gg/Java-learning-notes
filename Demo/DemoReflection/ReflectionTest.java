package DemoReflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



/*
* 问题1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中选哪一个？
* 答：直接new的方式
* 什么时候使用：反射的方式（代码量少）。反射的特征：动态性（编译的时候不知道用哪个类的对象
*             ，这时候就用反射的方式。如：客户端服务端，客户端在服务端运行时，登记或注册，这时候造对象）
* 问题2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
*       封装性：把对象的成员属性和成员方法结合成一个独立的相同单位，并尽可能隐蔽对象的内部细节
* 答：不矛盾
*
* 关于java.lang.Class类的理解
* 1.类的加载过程：
* 程序结果javac.exe命令后，会生成一个或多个字节码文件(.class结尾)。
* 接着我们用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
* 此过程就成为类的加载。加载到内存中的类，我们称为运行时类，此运行时类，就作为Class的一个实例。
* 2.换句话说，Class的实例就对应着一个运行时类。
* 3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们可以通过不同的方式来获取此运行时类。
* */
public class ReflectionTest {

    //反射之前，使用Person类做的事情
    @Test
    public void test1(){

        //创建对象
        Person per = new Person("kobe",41);

        //通过对象，调用内部属性与方法
        per.age = 10;
        System.out.println(per.toString());
        per.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有构造
        //比如：name，showNation
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class cla = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = cla.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Jordan",60);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = cla.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = cla.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("-----------------------------");

        //通过反射，调用Person类的私有结构
        //私有构造器
        Constructor cons1 = cla.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //私有属性
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Tom");
        System.out.println(p1);

        //私有方法
        Method showNation = cla.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");//相当于p1.showNation("中国")
    }

    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class class1 = Person.class;
        System.out.println(class1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p = new Person();
        Class class2 = p.getClass();
        System.out.println(class2);
        //方式三：通过调用Class的静态方法：forName(String classPath)
        Class class3 = Class.forName("DemoReflection.Person");
        System.out.println(class3);
        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class class4 = classLoader.loadClass("DemoReflection.Person");
        System.out.println(class4);

    }

}
