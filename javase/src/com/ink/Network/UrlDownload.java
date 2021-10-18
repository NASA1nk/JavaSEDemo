package com.ink.Network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDownload {

    public static void main(String[] args) throws Exception {
//        下载地址
        URL url = new URL("https://m701.music.126.net/20211015232932/2e557128a8bb5724d8a3e33d83eec832/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/7285619877/78ef/ec85/e69e/c8d97697a9edbb56cf282c87cff7dfed.m4a");
//        连接到资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("download.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
//        断开连接
        urlConnection.disconnect();
    }
}
