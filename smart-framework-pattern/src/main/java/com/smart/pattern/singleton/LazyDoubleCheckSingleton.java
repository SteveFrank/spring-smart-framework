package com.smart.pattern.singleton;

/**
 * 懒汉单例模式
 * volatile关键字避免了重排，同样可以保证了线程的安全
 * @author yangqian
 * @date 2021/1/5
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {}

    public static LazyDoubleCheckSingleton getInstance() {

        // 第一步检测
        if (instance == null) {
            // 同步
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    /*
                     * 反编译观察其执行顺序
                     * memory = allocate(); //1.分配对象内存空间
                     * instance(memory);    //2.初始化对象
                     * (程序执行器可能会任意调整该顺序，所以增加volatile关键字避免程序顺序重排序)
                     * instance = memory;   //3.设置instance指向刚分配的内存地址，此时instance！=null
                     */
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
