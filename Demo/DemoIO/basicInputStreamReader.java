package DemoIO;

import org.junit.Test;

import java.io.*;


/*
* 处理流之二：转换流的使用
*
* 1.转换流：属于字符流
*       InputStreamReader：将一个字节的输入流转换为字符的输入流
*       OutputStreamWriter：将一个字符的输出流转换为字节的输出流
*
* 2.作用：提供字节流与字符流之间的转换
*
* 3.解码：字节、字节数组----》字符数组、字符串
*   编码：字符数组、字符串----》字节、字节数组
*
* 4.字符集
* ASCII:美国标准信息交换码
*       用一个字节的7位可以表示。
* ISO8859-1:拉丁码表。欧洲码表
*       用一个字符的8位表示。
* CB2312：中国的中文编码表。最多两个字节编码所有字符
* GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
* Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。
* UTF-8：变长的编码方式，可用1-4个字节表示一个字符。
*
* */
public class basicInputStreamReader {

//  处理异常还是应该用try-catch-finally
    @Test
    public void test() throws IOException {

        FileInputStream fis = new FileInputStream("hello.txt");

        //参数2指明字符集，具体使用哪个字符集，取决于文件hello.txt保存时使用的字符集
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        char[] ch = new char[20];
        int len;
        while((len = isr.read(ch)) != -1){
            String str = new String(ch,0,len);
            System.out.println(str);
        }

        isr.close();
    }

    @Test
    public void test1() throws IOException {

        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        char[] ch = new char[20];
        int len;
        while ((len = isr.read(ch)) != -1){
            osw.write(ch,0,len);
        }

        isr.close();
        osw.close();
    }
}
