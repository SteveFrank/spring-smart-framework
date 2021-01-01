package com.smart.framwork.demo.entity.dto;

import com.smart.framwork.demo.entity.bo.HeadLine;
import com.smart.framwork.demo.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
