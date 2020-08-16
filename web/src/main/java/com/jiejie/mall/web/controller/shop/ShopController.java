package com.jiejie.mall.web.controller.shop;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.shop.ShopBiz;
import com.jiejie.mall.web.controller.shop.request.AddShopWebRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linseven
 * @Date 2020/8/16
 */
@RestController
public class ShopController {

    @Autowired
    private ShopBiz shopBiz;

    @PostMapping("/registry")
    public Response<Boolean> registry(@RequestBody AddShopWebRequest webRequest){
        Response<Boolean> response = new Response<>();
        response = shopBiz.registry(webRequest);
        return response;
    }
}
