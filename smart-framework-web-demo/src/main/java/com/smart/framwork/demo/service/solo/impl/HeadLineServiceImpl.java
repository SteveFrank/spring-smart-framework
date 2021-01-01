package com.smart.framwork.demo.service.solo.impl;

import com.smart.framwork.demo.entity.bo.HeadLine;
import com.smart.framwork.demo.entity.dto.Result;
import com.smart.framwork.demo.service.solo.HeadLineService;

import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class HeadLineServiceImpl implements HeadLineService {

    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
