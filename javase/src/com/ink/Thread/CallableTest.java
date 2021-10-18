package com.ink.Thread;

import java.util.concurrent.*;

/**
 * @author ink
 * @date 2021年08月02日20:37
 */
public class CallableTest implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件：" + name);
        return true;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DownloadDemo Test1 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "11.png");
        DownloadDemo Test2 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "22.png");
        DownloadDemo Test3 = new DownloadDemo("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "33.png");
//        创建执行服务（线程池）
        ExecutorService ser = Executors.newFixedThreadPool(3);
//        提交执行
        Future<Boolean> result1 = (Future<Boolean>) ser.submit(Test1);
        Future<Boolean> result2 = (Future<Boolean>) ser.submit(Test2);
        Future<Boolean> result3 = (Future<Boolean>) ser.submit(Test3);
//        获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
//        关闭服务
        ser.shutdownNow();

    }
}
