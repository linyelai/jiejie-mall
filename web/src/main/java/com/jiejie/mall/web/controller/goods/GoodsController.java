package com.jiejie.mall.web.controller.goods;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.goods.GoodsBiz;
import com.jiejie.mall.web.biz.product.ProductBiz;
import com.jiejie.mall.web.controller.goods.request.GoodsPageWebRequest;
import com.jiejie.mall.web.controller.goods.request.GoodsWebRequest;
import com.jiejie.mall.web.controller.goods.response.GoodsWebResponse;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.request.ProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author linseven
 * @Date 2020/5/5
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsBiz goodsBiz;
    @PostMapping("/goods")
    public Response<Boolean> addGoods(GoodsWebRequest webRequest){
        return goodsBiz.addGoods(webRequest);

    }
    @PutMapping("/goods")
    public Response<Boolean> updateGoods(GoodsWebRequest webRequest){
        return goodsBiz.updateGoods(webRequest);

    }
    @GetMapping("/goods")
    public PageResponse<GoodsWebResponse> findGoods(GoodsPageWebRequest webRequest){
        return goodsBiz.findGoods(webRequest);

    }
    @GetMapping("/goods/detail")
    public Response<GoodsWebResponse> findGoodsById(GoodsWebRequest webRequest){
        return goodsBiz.findGoodsById(webRequest);

    }
    @DeleteMapping("/goods")
    public Response<Boolean> DeleteProductById(GoodsWebRequest webRequest){
        return goodsBiz.deleteGoodsById(webRequest);

    }

}
