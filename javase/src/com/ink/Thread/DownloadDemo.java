package com.ink.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author ink
 * @date 2021年08月02日15:29
 */
public class DownloadDemo extends Thread{
    private String url;
    private String name;

    public DownloadDemo(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件：" + name);
    }

    public static void main(String[] args) {
        DownloadDemo Test1 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "1.png");
        DownloadDemo Test2 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "2.png");
        DownloadDemo Test3 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "3.png");
        Test1.start();
        Test2.start();
        Test3.start();
    }
}

class WebDownload{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
