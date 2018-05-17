package com.houlong.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by houlong on 2018/3/13.
 */
public class NioNonBlockingHttpClient {

    //打开选择器。 Selector是异步I/O中的核心对象。Selector就是您注册对各种I/O事件的兴趣的地方
    private static Selector selector;
    private Charset charset = Charset.forName("utf8");

    static {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        NioNonBlockingHttpClient client = new NioNonBlockingHttpClient();
        List<String> list = new ArrayList<>();
        list.add("www.baidu.com");
        list.add("www.weibo.com");
        list.add("www.sina.com");
        for (String host : list) {
            client.request(host, 80);
        }
        client.select();
    }

    public void request (String host, int port) throws IOException {
        // 打开客户端套接字通道。用于客户端链接
        SocketChannel socketChannel = SocketChannel.open();
        //设置超时时间
        socketChannel.socket().setSoTimeout(5000);
        //将新连接的套接字通道设置为非阻塞模式
        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress(host, port));
        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    public void select() throws IOException {
        while (selector.select(500) > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                //处理各种感兴趣的事件

                if (selectionKey.isConnectable()) {
                    connect(selectionKey);
                } else if (selectionKey.isReadable()) {
                    receive(selectionKey);
                } else if (selectionKey.isWritable()) {
                    write(selectionKey);
                }
            }
        }
    }

    private void write(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        InetSocketAddress remote = (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host = remote.getHostName();
        String request = compositeRequest(host);
        System.out.println(request);
        channel.write(charset.encode(request));
        selectionKey.interestOps(SelectionKey.OP_READ);
    }

    private void receive(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        String receiveData = charset.decode(buffer).toString();
        if ("".equals(receiveData)) {
            selectionKey.cancel();
            channel.close();
            return;
        }
        System.out.println(receiveData);
    }

    /**
     * 成功连接服务器
     * @param selectionKey
     */
    private void connect(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        channel.finishConnect();
        InetSocketAddress remote = (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host = remote.getHostName();
        int port = remote.getPort();
        System.out.println(String.format("访问地址：%s:%s 连接成功", host, port));
    }


    public String compositeRequest(String host){

        return "GET / HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "User-Agent: curl/7.43.0\r\n" +
                "Accept: */*\r\n\r\n";
    }
}
