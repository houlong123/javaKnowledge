package com.houlong.pattern.facade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 文件读取
 */
public class FileReader {

    public String read(String fileSrc) throws Exception{
        File file = new File(fileSrc);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line = br.readLine();
        sb.append(line == null ? "" : line);
        while (line != null) {
            line = br.readLine();
            if (line != null) {
                sb.append(line);
            }
        }
        br.close();
        return sb.toString();
    }
}
