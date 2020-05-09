package com.jiejie.mall.web.controller.sku;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.sku.SkuBiz;
import com.jiejie.mall.web.controller.sku.request.SkuRequest;
import com.jiejie.mall.web.controller.sku.response.SkuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkuController {
    @Autowired
    private SkuBiz skuBiz;
   public Response<Boolean> addSku(){
       return  skuBiz.addSku();
   }

   public Response<SkuResponse> findSku(SkuRequest skuRequest){

       return skuBiz.findSku(skuRequest);
   }
}
