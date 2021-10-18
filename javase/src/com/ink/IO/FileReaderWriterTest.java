package com.ink.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ink
 * @date 2021年05月31日21:13
 */
public class FileReaderWriterTest {
    @Test
    public void copytest() throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("ink.txt");
            File destFile = new File("copy.txt");
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            方法一
//            try {
//                if(fw != null){
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if(fr != null){
//                        fr.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//          方法二
            try {
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void writetest(){
        FileWriter fw = null;
        try {
            File file = new File("yinke.txt");
            fw = new FileWriter(file,false);

            fw.write("FileWriter test\n");
            fw.write("write test");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void readtest(){
        FileReader fr = null;
        try {
//            实例化File对象，指明操作文件
            File file = new File("ink.txt");
//            提供具体流
            fr = new FileReader(file);
//            read():返回读入的一个字符,达到文件末尾返回-1
//            int data;
//            while((data = fr.read()) != -1){
//                System.out.print((char) data);
//            }
            char[] charbuffer = new char[5];
            int len;
//            read(charbuffer):返回每次读入到charbuffer数组中的字符的个数,达到文件末尾返回-1
            while((len = fr.read(charbuffer)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print("第 " + i + "次" + " ");
                    System.out.print(charbuffer[i] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if中try catch也可以
            try {
//                关闭流
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
