package com.jiejie.mall.shop.mapper;

import com.jiejie.mall.shop.model.ShopAllInfo;
import com.jiejie.mall.shop.model.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper {

    /**
     *  新增会员
     * @param shopInfo
     * @return
     */
    public int addShop(Shop shopInfo);

    /**
     * 根据会员名查找会员信息
     * @return
     */
    public ShopAllInfo findShopByName(@Param(value = "shopName") String shopName);

    /**
     * 更新会员
     * @param shopInfo
     * @return
     */
    public int updateShop(ShopAllInfo shopInfo);

    /**
     * 根据会员id删除会员
     * @param id
     * @return
     */
    public int deleteShop(Integer id);

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    public ShopAllInfo findShopById(@Param(value = "id")Integer id);

}
