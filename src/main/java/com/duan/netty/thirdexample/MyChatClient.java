package com.duan.netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author DJ
 * @Date 2020-11-30 0:50
 */
public class MyChatClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8082).sync();
            while (true) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                channelFuture.channel().writeAndFlush(bufferedReader.readLine() + "\n");
            }
        } finally {
            eventExecutors.shutdownGracefully();
        }


    }
}
