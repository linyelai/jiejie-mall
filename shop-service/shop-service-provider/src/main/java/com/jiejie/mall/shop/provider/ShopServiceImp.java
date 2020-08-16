package com.jiejie.mall.shop.provider;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.shop.mapper.ShopMapper;
import com.jiejie.mall.shop.model.ShopInfo;
import com.jiejie.mall.shop.request.AddShopRequest;
import com.jiejie.mall.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author linseven
 * @Date 2020/8/16
 */
@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class ShopServiceImp implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Override
    public Response<Boolean> addShop(AddShopRequest request) {
        Response<Boolean>  response = new Response<>();
        ShopInfo shopInfo = BeanCopyUtil.copyProperties(ShopInfo.class,request);
        shopMapper.addShop(shopInfo);
        return response;
    }
}
