package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddGoodsRequest;
import com.jiejie.mall.product.request.DeleteGoodsRequest;
import com.jiejie.mall.product.request.GoodsRequest;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.service.GoodsService;


public class GoodsServiceImp implements GoodsService {

    public Response<Boolean> addGoods(AddGoodsRequest request){

        return  null;
    }

    public PageResponse<GoodsResponse> findProduct(GoodsRequest request){

        return null;
    }

    public Response<Boolean> updateProduct(GoodsRequest request){

        return  null;
    }

    public Response<Boolean> deleteProduct(DeleteGoodsRequest request){

        return null;
    }
}
