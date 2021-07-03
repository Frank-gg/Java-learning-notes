package DemoIO;

import org.junit.Test;

import java.io.*;


/*
* 一、流的分类：
* 1.操作数据单位：字节流、字符流
* 2.数据的流向：输入流、输出流
* 3.流的角色：节点流、处理流
*
* 二、流的体系
* 抽象基类           节点流(或文件流)              缓冲流
* InputStream       FileInputStream       BufferedInputStream
* OutputStream      FileOutputStream      BufferedOutputStream
* Reader            FileReader            BufferedReader
* Writer            FileWriter            BufferedWriter
* */



public class basicFileReaderWriter {

    public static void main(String[] args) {

        basicFileReaderWriter bk = new basicFileReaderWriter();
        bk.testFileReader();
    }
    /*
    * 将文件内容读入程序中，并输出到控制台
    *
    * 说明：
    * 1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    * 2.异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    * 3.读入的文件一定要存在，否则会报FileNotFoundException
    *
    * 从内存中写出数据到硬盘文件
    *
    * 说明：
    * 1.输出操作，对应的File（文件），文件可以不存在，并不会报异常；
    * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
    * 3.File对应的磁盘中的文件如果存在：
    *       如果流使用的构造器是：FileWriter(file，false)/FileWriter(file)：对原有文件进行覆盖
    *       如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原文件基础上追加内容
    */

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相当于当前的Module

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReader1(){

        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

            // read(char[] cbuf):返回每次读入cbuf数组的字符个数。
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //方式1 错误写法
/*                for (int i = 0; i < cbuf.length; i++) {
                    System.out.println(cbuf[i]);
                }*/
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }
                //方式2 错误写法
/*                String str = new String(cbuf);
                System.out.println(str);*/
                String str = new String(cbuf, 0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //文本复制
    @Test
    public void testFileReaderFileWriter() {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            File rr = new File("hello.txt");
            File wr = new File("hello1.txt");

            fr = new FileReader(rr);
            fw = new FileWriter(wr);

            int len; //记录每次读入到cbuf数组中数据（字符）的长度
            char[] cbuf = new char[5];
            while ((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
