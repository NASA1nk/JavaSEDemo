package com.ink.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ink
 * @date 2021年08月01日21:46
 */
public class RandomAccessFileTest {
        @Test
        public void test1() {

            RandomAccessFile raf1 = null;
            RandomAccessFile raf2 = null;
            try {
                raf1 = new RandomAccessFile(new File("ink.png"),"r");
                raf2 = new RandomAccessFile(new File("yinke.png"),"rw");

                byte[] buffer = new byte[1024];
                int len;
                while((len = raf1.read(buffer)) != -1){
                    raf2.write(buffer,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(raf1 != null){
                    try {
                        raf1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(raf2 != null){
                    try {
                        raf2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        @Test
        public void test2(){
            RandomAccessFile raf1 = null;
            try {
                raf1 = new RandomAccessFile("ink.txt","rw");
//            将指针调到角标为3的位置
                raf1.seek(3);
                raf1.write("xyz".getBytes());//
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(raf1 != null){
                    try {
                        raf1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

//        使用RandomAccessFile实现数据的插入效果
        @Test
        public void test3(){
            RandomAccessFile raf1 = null;
            try {
                raf1 = new RandomAccessFile("ink.txt","rw");
//            将指针调到角标为3的位置
                raf1.seek(3);
//            保存指针3后面的所有数据到StringBuilder中
//            数组长度用file.length()获得
                StringBuilder builder = new StringBuilder((int) new File("ink.txt").length());
                byte[] buffer = new byte[20];
                int len;
                while((len = raf1.read(buffer)) != -1){
                    builder.append(new String(buffer,0,len)) ;
                }
//            调回指针，写入“yinke”
                raf1.seek(3);
                raf1.write("yinke".getBytes());
//            将StringBuilder中的数据写入到文件中
                raf1.write(builder.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(raf1 != null){
                    try {
                        raf1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
