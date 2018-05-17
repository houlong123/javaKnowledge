package com.houlong.pattern.facade;

import java.io.BufferedWriter;
import java.io.File;

/**
 * 文件书写
 */
public class FileWriter {

    public void write(String encryptText, String fileDes) throws Exception {
        File file = new File(fileDes);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
        writer.write(encryptText);
        writer.flush();
        writer.close();
    }
}
