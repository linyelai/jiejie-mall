package com.jiejie.mall.product.mapper;

import com.jiejie.mall.product.model.GoodsInfo;
import com.jiejie.mall.product.service.GoodsService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {

     int addGoods(GoodsInfo goodsInfo);
     int updateGoods(GoodsInfo goodsInfo);
     int deleteGoods(Integer id);
     GoodsInfo findGoods(GoodsInfo goodsInfo);
     List<GoodsInfo> findGoodsByPage(Map param);

}
