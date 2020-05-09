package com.jiejie.mall.web.biz.sku;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddGoodsRequest;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.web.controller.sku.request.SkuRequest;
import com.jiejie.mall.web.controller.sku.response.SkuResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


@Service
public class SkuBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.product",check = false)
    GoodsService goodsService;
    public Response<Boolean> addSku(){

        Response<Boolean> response = new Response<>();
        AddGoodsRequest addGoodsRequest = new AddGoodsRequest();
        goodsService.addGoods(addGoodsRequest);
        return  response;
    }

    public Response<SkuResponse> findSku(SkuRequest skuRequest){

        Response<SkuResponse> response = new Response<>();

        return  response;
    }
}
