package com.ink.Network;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/hello/index.jsp?username=ink&password=123");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
    }
}
