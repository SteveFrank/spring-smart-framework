package com.smart.pattern.facade;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class Client {

    public static void main(String[] args) {
        LabourContractor labourContractor = new LabourContractor();
        labourContractor.buildHouse();
    }

}
