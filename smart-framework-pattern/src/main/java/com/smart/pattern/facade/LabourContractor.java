package com.smart.pattern.facade;

import com.smart.pattern.facade.subclass.BrickLayer;
import com.smart.pattern.facade.subclass.BrickWorker;
import com.smart.pattern.facade.subclass.Mason;

/**
 * 对于子系统方法的整合
 * @author yangqian
 * @date 2021/1/1
 */
public class LabourContractor {

    private Mason worker1 = new Mason();
    private BrickWorker worker2 = new BrickWorker();
    private BrickLayer worker3 = new BrickLayer();

    public void buildHouse() {
        worker1.mix();
        worker2.carry();
        worker3.neat();
    }

}
