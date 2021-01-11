package com.smart.pattern.template;

/**
 * @author yangqian
 * @date 2021/1/11
 */
public class RoomForChineseSinger extends KTVRoom {

    @Override
    protected void orderSong() {
        System.out.println("来首劲爆的中文歌... ...");
    }

    @Override
    protected void orderExtra() {
        System.out.println("东西真便宜，一样来一份... ...");
    }
}
