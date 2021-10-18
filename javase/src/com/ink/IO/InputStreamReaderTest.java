package com.ink.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author ink
 * @date 2021年06月01日23:04
 */
public class InputStreamReaderTest {
    @Test
    public void test1(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("copy.txt");
//        参数2指明了字符集，具体使用哪个字符集取决于文件保存时使用的字符集
//        使用系统默认的字符集
//        InputStreamReader isr = new InputStreamReader(fis);
//        使用UTF-8字符集
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(isr != null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test2() throws Exception {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("copy.txt");
            File file2 = new File("copy_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(isr != null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw != null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
