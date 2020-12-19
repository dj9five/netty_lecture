package com.duan.netty.decorator;

/**
 * @Author DJ
 * @Date 2020-12-07 22:49
 */
public class DecoratorC extends Decorator {
    public DecoratorC(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("功能C");
    }

}
