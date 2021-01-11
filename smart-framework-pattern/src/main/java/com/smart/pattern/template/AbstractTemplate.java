package com.smart.pattern.template;

/**
 *
 * 模板方法在Spring源码中 refresh 的实现是一个非常好的体现
 *
 * @author yangqian
 * @date 2021/1/11
 */
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod() {
        concreteMethod();
        hookMethod();
        abstractMethod();
    }

    /**
     * 模板中自带的方法实现
     */
    public void concreteMethod() {
        System.out.println("模板里自带的实现方法，万年不变");
    }

    /**
     * 钩子方法 子类可以依据情况来进行方法的实现
     */
    protected void hookMethod() {

    }

    /**
     * 抽象方法 子类必须实现的方法
     */
    public abstract void abstractMethod();

}
