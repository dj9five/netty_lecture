package com.duan.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author DJ
 * @Date 2020-12-09 22:36
 */
public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\JavaCode\\netty_lecture\\src\\main\\java\\com\\duan\\netty\\nio\\NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String message = "mi si ta bo bo";
        byteBuffer.put(message.getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
