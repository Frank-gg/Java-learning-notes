package DemoIO;

import org.junit.Test;

import java.io.*;

/*
* 对象流的作用
* 1.ObjectInputStream 和 ObjectOutputStream
* 2.作用：用于存储和读取基本数据类型数据或对象的处理流。
*        可以把java中的对象写入到数据源中(序列化)，也能把对象从数据源中还原回来(反序列化)
* 3.要想一个java对象可序列化，需要满足要求，见person类
* */

public class basicObjectStream {

    /*
    * 序列化过程：将内存中的java对象保存到磁盘中或者通过网络传输出去
    * 使用ObjectOutputStream实现
    * */
    @Test
    public void testBasicObjectStream(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("我爱中国"));
            oos.flush();

            //自定义类实现序列化
            oos.writeObject(new Person("kobe",43));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    * 使用ObjectInputStream实现
    * */
    public void testObjectInputStream(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
