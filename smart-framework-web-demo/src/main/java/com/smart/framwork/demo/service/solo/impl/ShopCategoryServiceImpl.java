package com.smart.framwork.demo.service.solo.impl;

import com.smart.framwork.demo.entity.bo.ShopCategory;
import com.smart.framwork.demo.entity.dto.Result;
import com.smart.framwork.demo.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
