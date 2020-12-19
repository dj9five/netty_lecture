package com.duan.netty.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer的类型化put和get
 * 读也需要按照写的顺序依次读
 *
 * @Author DJ
 * @Date 2020-12-14 23:22
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putChar('a');
        byteBuffer.putInt(10);
        byteBuffer.putDouble(20d);
        byteBuffer.putFloat(30f);
        byteBuffer.putShort((short) 40);
        byteBuffer.putLong(50L);

        byteBuffer.flip();
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getLong());

    }
}
