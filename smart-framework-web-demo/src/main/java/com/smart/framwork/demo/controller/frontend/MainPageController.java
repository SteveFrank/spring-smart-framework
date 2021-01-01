package com.smart.framwork.demo.controller.frontend;

import com.smart.framwork.demo.entity.dto.MainPageInfoDTO;
import com.smart.framwork.demo.entity.dto.Result;
import com.smart.framwork.demo.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }

}
