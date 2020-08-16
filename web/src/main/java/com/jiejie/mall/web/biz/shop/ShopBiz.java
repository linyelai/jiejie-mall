package com.jiejie.mall.web.biz.shop;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.shop.request.AddShopRequest;
import com.jiejie.mall.shop.service.ShopService;
import com.jiejie.mall.web.controller.shop.request.AddShopWebRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author linseven
 * @Date 2020/8/16
 */
@Service
public class ShopBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.shop",check = false)
    ShopService shopService;

    public Response<Boolean> registry(AddShopWebRequest webRequest){
        Response<Boolean> response = new Response<>();
        AddShopRequest addShopRequest = BeanCopyUtil.copyProperties(AddShopRequest.class,webRequest);
        response = shopService.addShop(addShopRequest);
        return response;

    }
}
