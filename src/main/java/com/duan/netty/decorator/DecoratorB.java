package com.duan.netty.decorator;

/**
 * @Author DJ
 * @Date 2020-12-07 22:49
 */
public class DecoratorB extends Decorator {
    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("功能B");
    }
}
