package com.duan.netty.nio;

import java.nio.ByteBuffer;

/**
 * 只读buffer 使用Buffer的asReadOnlyBuffer方法创建
 * 但是无法将一个读写buffer转换为只读buffer
 * @Author DJ
 * @Date 2020-12-14 23:24
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(512);
        ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
    }
}
