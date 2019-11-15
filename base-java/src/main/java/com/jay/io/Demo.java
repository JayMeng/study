package com.jay.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author jay
 * 文件操作io
 * @create 2019-11-07 11:09
 **/

public class Demo {

    public static void main(String[] args) {

    }

    private static void readFile1(String path) throws Exception {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    private static void readFile2(String path) throws Exception {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }


    private static void writeFile1(String path) throws Exception {
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write("dada");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private static void writeFile2(String path) throws Exception {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("dada");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    /**
     * ------------------------------  以上是Java8之前的实现
     * 华丽的分隔符
     * 以下是Java8的实现   ---------------------------------------
     **/


    private static void readFile8(String path) throws Exception {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.lines().filter(line -> line.length() > 2).filter(line -> line.contains("dmeo")).forEach(line -> System.out.println(line));
    }

    /**
     * @Author mj
     * @Description Path用于来表示文件路径和文件，和File对象类似，Path对象并不一定要对应一个实际存在的文件， 它只是一个路径的抽象序列。
     * @Date 2019/11/7 14:33
     **/
    private static void readFile8() throws IOException {
        //  如果希望按照行读取文件，可以调用
        List<String> lines = Files.readAllLines(Paths.get("/home/biezhi/a.txt"));
        //  反之，写入文件 APPEND = 追加
        Files.write(Paths.get("/home/biezhi/a.txt"), "Hello World".getBytes(), StandardOpenOption.APPEND);

        Path path = Paths.get("/home/biezhi", "a.txt");
        InputStream ins = Files.newInputStream(path);
        OutputStream ops = Files.newOutputStream(path);
        Reader reader = Files.newBufferedReader(path);
        Writer writer = Files.newBufferedWriter(path);
    }
}
