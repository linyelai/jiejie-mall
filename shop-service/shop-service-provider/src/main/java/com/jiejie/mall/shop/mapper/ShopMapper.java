package com.jiejie.mall.shop.mapper;

import com.jiejie.mall.shop.model.ShopInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {
    int addShop(ShopInfo shopInfo);
}
