package com.duan.netty.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * sliceBuffer 和原buffer共享相同的底层数组，一个改变另一个也会改变
 *
 * @Author DJ
 * @Date 2020-12-14 23:20
 */
public class NioTest6 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
        }

        buffer.position(0);
        buffer.limit(5);

        IntBuffer slice = buffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            int i1 = slice.get(i);
            slice.put(i, i1 * 2);
        }
        buffer.clear();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
