package com.hollysys.hiadsp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件操作类
 */
public class FileUtil {

    /**
     * 文件写入（一次性写入）
     * @param fileName
     * @param value
     */
    public static void writeToFile(String fileName,String value){
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fileWriter);
            pw.println(value);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        writeToFile("E://project-test/11",2+"");
    }
}
