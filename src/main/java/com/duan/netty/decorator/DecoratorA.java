package com.duan.netty.decorator;

/**
 * @Author DJ
 * @Date 2020-12-07 22:47
 */
public class DecoratorA implements Component {

    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
