package DemoIO;

import org.junit.Test;
import java.io.*;



/*
*处理流之一：缓冲流的使用
*
* 1.缓冲流：
* BufferedInputStream
* BufferedOutputStream
* BufferedReader
* BufferedWriter
*
* 2.作用：
* 提供流的读取、写入的速度
*
* 3.处理流：就是“嵌套”在已有流的基础上的流
* */

public class basicBuffer {

    @Test
    public void BufferedStreamTest() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File fi = new File("src//hello.txt");
            File fo = new File("src//hello1.txt");

            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(fi);
            FileOutputStream fos = new FileOutputStream(fo);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //创造相应的流与文件（1与2可以合并了写）
            //bis = new BufferedInputStream(new FileInputStream(new File("src//hello.txt")));
            //bos = new BufferedOutputStream(new FileOutputStream(new File("src//hello1.txt")));

            //3.复制:读取、写入
            byte[] bt = new byte[5];
            int len;
            while ((len = bis.read(bt)) != -1){
                bos.write(bt,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                //4.资源关闭
                //要求：先关闭外层的流，再关闭内层的流
                //说明：在关闭外层的流的时候，内层的流会自动关闭，所以可以省略内存流的关闭。
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 使用BufferedReader和BufferedWriter实现文本文件的复制
    */
    @Test
    public void testBufferedReaderAndWriter() {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //1.创造相应的流与文件
            br = new BufferedReader(new FileReader(new File("src//hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("src//hello1.txt")));

            //2.读写操作
            //方式一：使用char[]数组
/*            char[] ch = new char[1024];
            int len;
            while ((len = br.read(ch)) != -1){
                bw.write(ch,0,len);
            }*/

            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                //1.加换行
//                bw.write(data + "\n");//使用换行符
                //2.加换行
                bw.write(data);
                bw.newLine();//提供换行的操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                //3.关闭资源
               if(br != null){
                   try {
                       br.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if(bw != null){
                   try {
                       bw.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
        }
    }

    //文件加密：用文件中的数据与其他数字异或
    //文件解密：加密的文件与异或的数字再次异或
    @Test
    public void encryptionMethod() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("src/火神.webp");
            fos = new FileOutputStream("src/火神1.webp");

            byte[] bt = new byte[20];
            int len;
            while ((len = fis.read(bt)) != -1){

                //文件加密读入
                for (int i = 0; i < len; i++) {
                    //字节数组进行修改
                    //错误写法，相当于还是整个数组在传数据
    /*                for (byte b : bt) {
                        b = (byte) (b ^ 5);
                    }*/
                    bt[i] = (byte) (bt[i] ^ 5);
                }
                fos.write(bt,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
