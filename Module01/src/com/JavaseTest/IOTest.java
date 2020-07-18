package com.JavaseTest;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOTest {
    //字节节点流
    @Test
    public void test1() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File file1 = new File("test1.txt");
            File file2 = new File("test2.txt");
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);
            char[] ch = new char[4];
            int len;
            while((len=fileReader.read(ch))!=-1){
                fileWriter.write(new String(ch),0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //字节缓冲流
    @Test
    public void test2() {
        FileInputStream fileinputStream = null;
        FileOutputStream fileoutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file1 = new File("No game no life.png");
            File file2 = new File("No game no life2.png");
            fileinputStream = new FileInputStream(file1);
            fileoutputStream = new FileOutputStream(file2);
            bufferedInputStream = new BufferedInputStream(fileinputStream);
            bufferedOutputStream = new BufferedOutputStream(fileoutputStream);
            byte[] bytes = new byte[10];
            int len;
            while((len=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //字符缓冲流
    @Test
    public void test3(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("test1.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("test2.txt")));
            char[] cbuf = new char[4];
            int len;
            while((len=bufferedReader.read(cbuf))!=-1){
                bufferedWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //转换流
    @Test
    public void test4() throws FileNotFoundException {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File("test1.txt")), StandardCharsets.UTF_8);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("test2.txt")),"GBK");
            char[] cbuf = new char[4];
            int len;
            while((len=inputStreamReader.read(cbuf))!=-1){
                outputStreamWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}