package DemoNetworkProgram;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/*
* 实现TCP的网络编程
* 例子1：客户端发出信息给服务端，服务端将数据显示在控制台
* */
public class TCPTest {

    //客户端
    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建Socket对象，指明服务端的IP与端口号
            InetAddress IP = InetAddress.getByName("125.86.164.225");
            socket = new Socket(IP,8889);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3.写出数据的操作
            os.write("你好，我是客户端！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void serve(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建服务端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8889);
            //2.调用accept()方法，表示接受来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流，用于读数据
            is = socket.getInputStream();

            //不建议这样写
/*      byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);*/
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();//字节数组输出流在内存中创建一个字节数组缓冲区
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
