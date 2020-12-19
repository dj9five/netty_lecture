package com.duan.netty.decorator;

/**
 * @Author DJ
 * @Date 2020-12-07 22:52
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new DecoratorC(new DecoratorA());
        component.doSomething();
    }

}
