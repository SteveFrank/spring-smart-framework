package com.smart.pattern.singleton;

/**
 * @author yangqian
 * @date 2021/1/5
 */
public class EnumStarvingSingleton {

    private EnumStarvingSingleton() {}

    public static EnumStarvingSingleton getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        /**
         * 封装私有的单例
         */
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder() {
            instance = new EnumStarvingSingleton();
        }
    }

}
