package com.duan.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author DJ
 */
public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        //boss用来接收进来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用来处理已经被接收的连接
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //快速创建channel
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //创建一个NioServerSocketChannel 使用两个线程组 连接请求来了用childHandler处理
            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());
            //同步绑定8080端口
            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            //同步等待通道的关闭事件 一直等待
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅关闭线程组
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
