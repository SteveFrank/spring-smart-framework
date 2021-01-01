package com.smart.framwork.demo.service.solo;

import com.smart.framwork.demo.entity.bo.HeadLine;
import com.smart.framwork.demo.entity.dto.Result;

import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineId);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>>queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);

}
