package com.houlong.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by houlong on 2018/2/28.
 */
public class NioServer {

    static {
        System.out.println("1");
    }

    public NioServer() {
        System.out.println("2");
    }

    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    String str;

    public void start() throws IOException {
        // 打开服务器套接字通道。用于服务端接收链接
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 服务器配置为非阻塞,在其之后的代码，才是非阻塞的
        ssc.configureBlocking(false);
        // 进行服务的绑定
        ssc.bind(new InetSocketAddress("127.0.0.1", 8001));

        // 通过open()方法找到Selector

        selector = Selector.open();


        // 注册到selector，等待连接。这里它指定我们想要监听accept事件，也就是在新的连接建立时所发生的事件。
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (!Thread.currentThread().isInterrupted()) {

            // 获取就绪的 socket 个数，在大于0的时候，才会事件处理。selector.select()是同步阻塞的，等待有事件发生后，才会被唤醒。这就防止了 CPU 空转的产生
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (!selectionKey.isValid()) {
                    continue;
                }

                //注册感兴趣的事件

                //客户端链接
                if (selectionKey.isAcceptable()) {
                    accept(selectionKey);
                }

                //进行读操作
                if (selectionKey.isReadable()) {
                    read(selectionKey);
                }

                //进行写操作
                if (selectionKey.isWritable()) {
                    write(selectionKey);
                }

                //该事件已经处理，可以丢弃
                iterator.remove();
            }
        }
    }

    private void  write (SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("write:"+str);

        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        sendBuffer.flip();
        channel.write(sendBuffer);
        channel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        //清除原字节数组
        readBuffer.clear();

        int numRead;

        try {
            numRead = channel.read(readBuffer);
        } catch (IOException e) {
            key.cancel();
            channel.close();

            return;
        }

        str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        channel.register(selector, SelectionKey.OP_WRITE);
    }

    private void accept(SelectionKey key) throws IOException {

        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = channel.accept();

        //设置
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);

        System.out.println("a new client connected " + clientChannel.getRemoteAddress());
    }


    public static void main(String[] args) throws IOException {
        System.out.println("启动服务端。。。");
        new NioServer().start();
    }
}
