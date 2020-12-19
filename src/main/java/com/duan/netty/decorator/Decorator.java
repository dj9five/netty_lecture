package com.duan.netty.decorator;

/**
 * @Author DJ
 * @Date 2020-12-07 22:45
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        this.component.doSomething();
    }
}
