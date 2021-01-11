package com.smart.pattern.template;

/**
 * @author yangqian
 * @date 2021/1/11
 */
public class RoomForAmericanSinger extends KTVRoom {

    @Override
    protected void orderSong() {
        System.out.println("Chinese song in English version please...");
    }
}
