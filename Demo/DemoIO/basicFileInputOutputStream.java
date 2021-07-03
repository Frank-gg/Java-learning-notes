package DemoIO;


import org.junit.Test;

import java.io.*;

/*
* 结论：
* 1.对于文本文件（.txt，.java，.c，.cpp），使用字符流处理；
* 2.非文本文件（.jpg，.MP3，.MP4，.avi，.doc，.ppt，...），使用字节流处理；
* 3.文本文件，若只是复制，且不会在内存层面去read（）（不在控制台查看），也可以用字节流处理
* */
public class basicFileInputOutputStream {

    @Test
    public void testFileInputStream() {

        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file);

            int len;
            byte[] buffer = new byte[5];
            while ((len = fis.read(buffer)) != -1){

                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 实现对图片的复制操作
    * */
    @Test
    public void testFileInputOutputStream() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File fi = new File("E:\\IdeaProjects\\test\\javaTestCode\\src\\火神.webp");
            File fo = new File("E:\\IdeaProjects\\test\\javaTestCode\\src\\大我.webp");

            fis = new FileInputStream(fi);
            fos = new FileOutputStream(fo);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void copyMethed(String srcPath, String deskpath){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File fi = new File(srcPath);
            File fo = new File(deskpath);

            fis = new FileInputStream(fi);
            fos = new FileOutputStream(fo);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "E:\\IdeaProjects\\test\\javaTestCode\\src\\火神.webp";
        String deskPath = "E:\\IdeaProjects\\test\\javaTestCode\\src\\大我.webp";

/*      String srcPath = "hello.txt";
        String deskPath = "hello2.txt";*/

        copyMethed(srcPath,deskPath);

        long end = System.currentTimeMillis();

        System.out.println("运行时间：" + (end - start));
    }

}
