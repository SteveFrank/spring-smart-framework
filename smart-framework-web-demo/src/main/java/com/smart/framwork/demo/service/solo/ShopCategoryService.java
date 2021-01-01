package com.smart.framwork.demo.service.solo;

import com.smart.framwork.demo.entity.bo.ShopCategory;
import com.smart.framwork.demo.entity.dto.Result;

import java.util.List;

/**
 * @author yangqian
 * @date 2021/1/1
 */
public interface ShopCategoryService {

    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);

}
