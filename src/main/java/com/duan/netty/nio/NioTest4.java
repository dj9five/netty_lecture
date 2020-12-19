package com.duan.netty.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * flip  position指向0 limit指向position原来的位置，写操作完成后，position和limit相同
 * clear position指向初始0的位置  limit指向最大值capacity
 * NIO操作文件的步骤
 * 1.获取输入流channel
 * 2.获取输出流channel
 * 3.创建ByteBuffer
 * 4.死循环 buffer.clear  读取输入流channel的数据到buffer
 * 5.buffer.flip buffer   buffer的数据写入输出流channel
 * 6.输入流输出流关闭
 *
 * @Author DJ
 * @Date 2020-12-14 22:58
 */
public class NioTest4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\JavaCode\\netty_lecture\\src\\main\\java\\com\\duan\\netty\\nio\\NioTest4.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\JavaCode\\netty_lecture\\src\\main\\java\\com\\duan\\netty\\nio\\NioTest5.txt");

        FileChannel readChannel = fileInputStream.getChannel();
        FileChannel writeChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        while (true) {
            byteBuffer.clear();
            int read = readChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
        }
       fileInputStream.close();
        fileOutputStream.close();

    }
}
