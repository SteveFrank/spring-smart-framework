package com.smart.pattern.template;

/**
 *
 * Spring 中很好的模板方法使用例子
 *  => org.springframework.context.support.AbstractApplicationContext#refresh
 *
 * @author yangqian
 * @date 2021/1/11
 */
public class TemplateDemo {

    public static void main(String[] args) {
        KTVRoom room1 = new RoomForChineseSinger();
        room1.procedure();
        System.out.println(" ===================== ");
        KTVRoom room2 = new RoomForAmericanSinger();
        room2.procedure();
    }

}
