package com.smart.framwork.demo.service.combine;

import com.smart.framwork.demo.entity.dto.MainPageInfoDTO;
import com.smart.framwork.demo.entity.dto.Result;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();

}
