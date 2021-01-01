package com.smart.framwork.demo.controller.superadmin;

import com.smart.framwork.demo.entity.bo.HeadLine;
import com.smart.framwork.demo.entity.dto.Result;
import com.smart.framwork.demo.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class HeadLineOperationController {

    private HeadLineService headLineService;
    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp){
        // TODO:参数校验以及请求参数转化
        HeadLine headLine = new HeadLine();
        Result<Boolean> result = headLineService.addHeadLine(headLine);
        return result;
    }

    public void removeHeadLine(){
        // TODO:参数校验以及请求参数转化
        System.out.println("删除HeadLine");
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
        // TODO:参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp){
        // TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>>queryHeadLine(){
        // TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLine(null, 1, 100);
    }
}
