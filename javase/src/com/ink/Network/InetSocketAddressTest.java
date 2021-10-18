package com.ink.Network;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author ink
 * @date 2021年08月06日11:09
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1", 12345);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost", 12345);
        System.out.println(inetSocketAddress1);
        System.out.println(inetSocketAddress2);
        System.out.println("方法");
        InetAddress address = inetSocketAddress1.getAddress();
        String hostName = inetSocketAddress1.getHostName();
        int port = inetSocketAddress1.getPort();
        System.out.println(address);
        System.out.println(hostName);
        System.out.println(port);

    }
}
