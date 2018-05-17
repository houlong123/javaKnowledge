package com.houlong.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by houlong on 2018/2/28.
 */
public class NioClient {

    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private void start() throws IOException {
        SocketChannel channel = SocketChannel.open();

        // 将新连接的套接字通道设置为非阻塞模式
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", 8001));

        //打开选择器。 Selector是异步I/O中的核心对象。Selector就是您注册对各种I/O事件的兴趣的地方
        Selector selector = Selector.open();

        //注册连接服务器socket的动作
        channel.register(selector, SelectionKey.OP_CONNECT);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 这个方法会阻塞，直到至少有一个已注册的事件发生。
            // 当一个或者更多的事件发生时，此方法将返回所发生的事件的数量。
            selector.select();

            // 迭代所有的选择键，以处理特定的I/O事件。
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 删除处理过的选择键
                iterator.remove();
                // 判断此通道上是否正在进行连接操作。
                if (key.isConnectable()) {

                    // 真正的完成 socket 连接
                    channel.finishConnect();
                    channel.register(selector, SelectionKey.OP_WRITE);
                    System.out.println("server connected...");
                    break;

                    //写数据
                } else if (key.isWritable()) {
                    System.out.println("请写入信息：");
                    String message = scanner.nextLine();

                    writeBuffer.clear();
                    writeBuffer.put(message.getBytes());
                    //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
                    writeBuffer.flip();
                    channel.write(writeBuffer);

                    // 接受连接后，在此通道上从新注册读取事件，以便接收数据。
                    channel.register(selector, SelectionKey.OP_READ);

                    //读数据
                } else if(key.isReadable()) {
                    System.out.println("接收数据：");

                    // 接受服务器套接字撒很能够传入的新的连接，并处理接受连接事件。
                    SocketChannel sc = (SocketChannel) key.channel();

                    readBuffer.clear();
                    int num = sc.read(readBuffer);
                    System.out.println(new String(readBuffer.array(),0, num));
                    //注册写操作，下一次写
                    sc.register(selector, SelectionKey.OP_WRITE);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new NioClient().start();
    }
}
