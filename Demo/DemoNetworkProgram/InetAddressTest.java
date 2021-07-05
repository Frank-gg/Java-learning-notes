package DemoNetworkProgram;


import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* 一、网络编程中两个主要问题：
* 1.如何准确定位网络上一台或多台主机；定位主机上的特定的应用
* 2.找到主机后如何可靠高效的进行数据传输
*
* 二、网络编程中的两个要素
* 1.对应问题一：IP（Internet Protocol）与端口号
* 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
*
* 三、通信要素一：IP与端口号
* 1.IP：唯一的标识Internet上的计算机（通信实体）
* 2.在Java中使用InetAddress类代表IP
* 3.IP分类：IPv4和IPv6；万维网和局域网
* 4.域名：www.baidu.com  www.mi.com
* 5.本地回路地址：127.0.0.1 对应着：localhost
* 6.如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
* 7.端口号：正在计算机上运行的进程
*      要求：不同的进程有不同的端口号
*      范围：被规定为一个16位的整数：0-65535
* 8.端口号与IP地址的组合得出一个网络套接字：Socket
* */
public class InetAddressTest {

    public static void main(String[] args) {
        try {

            InetAddress inet1 = InetAddress.getByName("125.86.164.225");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.nb.com");
            System.out.println(inet2);

            //获取本机IP
            InetAddress inet3 = InetAddress.getLocalHost();
            InetAddress inet4 = InetAddress.getByName("125.86.164.225");//里面输入本机IP

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
