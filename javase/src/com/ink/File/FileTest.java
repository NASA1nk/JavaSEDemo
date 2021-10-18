package com.ink.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author ink
 * @date 2021年05月30日20:55
 */
public class FileTest {
    @Test
    public void test6() throws IOException {
        File file = new File("ink.md");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }
        else{
            file.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test5(){
        File file = new File("C:\\Users\\54164\\Desktop\\File");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    @Test
    public void test4(){
        File file1 = new File("ink.txt");
        File file2 = new File("C:\\Users\\54164\\Desktop\\File\\yinke.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }
    @Test
    public void test3(){
        File file = new File("C:\\Users\\54164\\Desktop\\javase\\javase\\src\\com\\ink");
        String[] lists = file.list();
        for(String l : lists){
            System.out.println(l);
        }
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        File file1 = new File("ink.md");
        File file2 = new File("C:\\Users\\54164\\Desktop\\File");
        System.out.println("ink");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println();
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
        System.out.println(new Date(file2.lastModified()));

    }
    @Test
    public void test1(){
        File file1 = new File("ink.md");
        // ink.md
        System.out.println(file1);
        File file2 = new File("C:\\Users\\54164\\Desktop\\File");
        // C:\Users\54164\Desktop\File
        System.out.println(file2);
        File file3 = new File("C:\\Users\\54164\\Desktop\\File", "ink");
        // C:\Users\54164\Desktop\File\ink
        System.out.println(file3);
        File file4 = new File("file3", "ink.txt");
        // file3\ink.txt
        System.out.println(file4);
    }
}
