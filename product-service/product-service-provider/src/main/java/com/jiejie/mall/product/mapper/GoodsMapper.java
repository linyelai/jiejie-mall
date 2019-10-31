package com.jiejie.mall.product.mapper;

import com.jiejie.mall.product.model.GoodsInfo;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    public int addGoods(GoodsInfo goodsInfo);
    public int updateGoods(GoodsInfo goodsInfo);
    public int deleteGoods(Integer id);
    public List<GoodsInfo> findGoodsByPage(Map param);
}
