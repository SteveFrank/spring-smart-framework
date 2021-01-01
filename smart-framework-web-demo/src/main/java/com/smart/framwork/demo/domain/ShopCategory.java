package com.smart.framwork.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author yangqian
 * @date 2021/1/1
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
