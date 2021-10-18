package com.ink.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author ink
 * @date 2021年06月01日20:57
 */
public class BufferedTest {
    @Test
    public void test2(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("ink.txt")));
            bw = new BufferedWriter(new FileWriter(new File("yinke.txt")));
//        方法一:
//        char[] cbuf = new char[1024];
//        int len;
//        while((len = br.read(cbuf)) != -1){
//            bw.write(cbuf,0,len);
//        }
//        方法二:
            String data;
            while((data = br.readLine()) != null) {
//                不包括换行符
                bw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//           fos.close();
//           fis.close();
        }
    }
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("yinke.png");
            File destFile = new File("inkyinke.png");
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//           fos.close();
//           fis.close();
        }
    }
}
