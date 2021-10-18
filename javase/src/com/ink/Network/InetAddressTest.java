package com.ink.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ink
 * @date 2021年08月06日10:19
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
//            获取本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress1);
            System.out.println(inetAddress2);
            System.out.println(inetAddress3);

//            获取网站ip地址
            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
