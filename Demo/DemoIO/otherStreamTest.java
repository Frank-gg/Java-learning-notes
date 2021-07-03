package DemoIO;


import org.junit.Test;

import java.io.*;

/*
*1.标准的输入、输出流
* 1.1
*   System.in：标准的输入流，默认从键盘输入
*   System.out：标准的输出流，默认从控制台输出
* 1.2
*   System类的setIn(InputStream is)/setOut(PrintStream)方式重新指定输入和输出的的流
*
*2.打印流
*
*3.数据流
*3.1 DataInputStream 和 DataOutputStream
*3.2 作用：用于读取或写出基本数据类型的变量或字符串
* */
public class otherStreamTest {
/*  练习：
    从键盘输入字符串，要求将读取到的整行字符串转换为大写输出。然后继续进行输入操作，
    直至当输入"e"或者"exit"时，退出程序。

    方法一：使用Scanner实现，调用next()返回一个字符串
    方法二：使用System.in实现。System.in ---> 转换流 --->BufferedReader的readLine()

    */
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //打印流
    public void test2() {

        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\downland"));

            //创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时，都会刷新缓冲区）
            ps = new PrintStream(fos,true);
            if(ps != null){
                System.setOut(ps);
            }

            for (int i = 0; i < 255; i++) {
                System.out.println((char)i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
        }
    }

    //数据流
    @Test
    public void test3() throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("观娃子");
        dos.flush();//刷新操作
        dos.writeInt(23);
        dos.flush();

        dos.close();
    }
}
