package DemoNetworkProgram;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/*
* 实现TCP的网络编程
* 例题2：客户端发送文件给服务端，服务端将文件保存到本地
*
* */
public class TCPTest1 {
    //客户端
    @Test
    public void client() throws IOException {
        //客户端套接字,Socket类：使一个应用从网络中读取和写入数据
        Socket socket = new Socket(InetAddress.getByName("125.86.164.225"),8848);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("火神.webp"));

        byte[] bt = new byte[1024];
        int len;
        while ((len = fis.read(bt)) != -1){
            os.write(bt,0,len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        fis.close();
        os.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //服务端套接字
        ServerSocket ss = new ServerSocket(8848);
        Socket socket = ss.accept();//等待客户机的连接，若连接，则创建一个套接字
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("火神1.webp"));

        byte[] bt = new byte[1021];
        int len;
        while ((len = is.read(bt)) != -1){
            fos.write(bt,0,len);
        }

        fos.close();
        is.close();
        ss.close();
        socket.close();
    }
}
