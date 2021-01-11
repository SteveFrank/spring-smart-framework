package com.smart.pattern.template;

/**
 *
 * 模板方法的例子
 * 场景 KTV
 * @author yangqian
 * @date 2021/1/11
 */
public abstract class KTVRoom {

    public void procedure(){
        openDevice();
        orderSong();
        orderExtra();
        pay();
    }

    /**
     * 模板方法自带的必备方法
     * => KTV在使用之前必须打开设备
     */
    private void openDevice() {
        System.out.println("打开视频和音响");
    }

    /**
     * 子类需要实现的方法
     * => 进入KTV 后子类的实现必须选歌
     */
    protected abstract void orderSong();

    /**
     * 钩子，额外的开销情况根据选择决定
     * => 点菜或者其他服务
     */
    protected void orderExtra() {};

    /**
     * 必须执行的方法
     */
    private void pay() {
        System.out.println("支付本次的消费账单");
    }

}
