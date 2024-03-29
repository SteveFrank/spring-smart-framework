package com.smart.framework.simple.demo.generic;

import java.util.Random;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class RobotFactory implements GenericFactory<String, Integer> {

    private String[] stringRobot = new String[]{"Hello", "Hi"};
    private Integer[] integerRobot = new Integer[]{111, 100};

    @Override
    public String nextObject() {
        Random random = new Random();
        return stringRobot[random.nextInt(2)];
    }

    @Override
    public Integer nextNumber() {
        Random random = new Random();
        return integerRobot[random.nextInt(2)];
    }

    public static void main(String[] args) {
        GenericFactory<String, Integer> factory = new RobotFactory();
        System.out.println(factory.nextObject());
        System.out.println(factory.nextNumber());
    }

}
