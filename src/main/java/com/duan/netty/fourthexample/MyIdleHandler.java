package com.duan.netty.fourthexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @Author DJ
 * @Date 2020-11-30 22:57
 */
public class MyIdleHandler extends ChannelInboundHandlerAdapter {
    /**
     * 用户事件触发
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String evertType = null;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    evertType = "读超时";
                    break;
                case WRITER_IDLE:
                    evertType = "写超时";
                    break;
                case ALL_IDLE:
                    evertType = "读写超时";
                    break;
                default:
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " 超时事件 ：" + evertType);
            ctx.channel().close();
        }
    }
}
