package com.houlong.java.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by houlong on 2018/2/28.
 */
public class NioTest {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("/Users/houlong/name.txt");

        FileOutputStream outputStream = new FileOutputStream("/Users/houlong/nameCopy.txt");

        //为文件输入流创建文件通道
        FileChannel channel = inputStream.getChannel();

        FileChannel fout = outputStream.getChannel();

        //开辟一个长度为1024的字节缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(32);

        while (true) {
            //重新设置缓冲区，使其可以接受读入的数据
            buffer.clear();

            int r = channel.read(buffer);

            buffer.get(1);
            byte b = 0;
            buffer.put(b);
            buffer.put(b);
            buffer.put(b);
            buffer.put(b);
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            if (r == -1) {
                break;
            }

            buffer.flip();
            fout.write(buffer);
        }

        channel.close();
        inputStream.close();

        fout.close();
        outputStream.close();
    }
}
