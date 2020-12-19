package com.duan.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;


/**
 * @Author DJ
 * @Date 2020-12-09 22:14
 */
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < 10; i++) {
            int item = new SecureRandom().nextInt(20);
            intBuffer.put(item);
        }
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
