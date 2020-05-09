package com.jiejie.mall.web.biz.goods;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.request.*;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.response.ProductResponse;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.stock.service.StockService;
import com.jiejie.mall.web.controller.goods.request.GoodsPageWebRequest;
import com.jiejie.mall.web.controller.goods.request.GoodsWebRequest;
import com.jiejie.mall.web.controller.goods.response.GoodsWebResponse;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.request.ProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author linseven
 * @Date 2020/5/5
 */

@Service
public class GoodsBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.product",check = false)
    GoodsService goodsService;
    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.stock",check = false)
    StockService stockService;
    public Response<Boolean> addGoods(@RequestBody GoodsWebRequest webRequest){
        Response<Boolean> response = new Response<>();
        AddGoodsRequest addGoodsRequest = BeanCopyUtil.copyProperties(AddGoodsRequest.class,webRequest);
        Response<Boolean> addProductResponse = goodsService.addGoods(addGoodsRequest);
        //保存库存
        response.setData(addProductResponse.getData());
        return response;

    }
    public Response<Boolean> updateGoods(GoodsWebRequest webRequest){
        Response<Boolean> response = new Response<>();
        GoodsRequest goodsRequest = BeanCopyUtil.copyProperties(GoodsRequest.class,webRequest);
        Response<Boolean> updateProductResp = goodsService.updateGoods(goodsRequest);
        response.setData(updateProductResp.getData());
        return response;

    }
    public PageResponse<GoodsWebResponse> findGoods(GoodsPageWebRequest webRequest){
        PageResponse<GoodsWebResponse> response = new PageResponse<>();
        GoodsPageRequest goodsPageRequest = BeanCopyUtil.copyProperties(GoodsPageRequest.class,webRequest);
        PageResponse<GoodsResponse> productResponse = goodsService.findGoods(goodsPageRequest);
        response.setSuccess(productResponse.getSuccess());
        List<GoodsWebResponse> productWebResponse = BeanCopyUtil.copyList(GoodsWebResponse.class,productResponse.getData());
        response.setData(productWebResponse);
        return response;

    }
    public Response<GoodsWebResponse> findGoodsById(GoodsWebRequest webRequest){
        Response<GoodsWebResponse> response = new Response<>();
        GoodsRequest goodsRequest = BeanCopyUtil.copyProperties(GoodsRequest.class,webRequest);
        Response<GoodsResponse> goodsResponse  = goodsService.findById(goodsRequest);
        GoodsWebResponse goodsWebResponse = BeanCopyUtil.copyProperties(GoodsWebResponse.class,goodsResponse.getData());
        response.setData(goodsWebResponse);
        return response;

    }

    public Response<Boolean> deleteGoodsById(GoodsWebRequest request){

        Response<Boolean> response = new Response<>();
        DeleteGoodsRequest deleteProductRequest = BeanCopyUtil.copyProperties(DeleteGoodsRequest.class,request);
        Response<Boolean> deleteResponse = goodsService.deleteGooods(deleteProductRequest);
        response.setData(deleteResponse.getData());
        return response;

    }
}
