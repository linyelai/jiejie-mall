package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.mapper.GoodsMapper;
import com.jiejie.mall.product.model.GoodsInfo;
import com.jiejie.mall.product.request.AddGoodsRequest;
import com.jiejie.mall.product.request.DeleteGoodsRequest;
import com.jiejie.mall.product.request.GoodsRequest;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class GoodsServiceImp implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    public Response<Boolean> addGoods(AddGoodsRequest request){

        Response<Boolean> response = new Response<>();
        GoodsInfo goodsInfo = BeanCopyUtil.copyProperties(GoodsInfo.class,request);
        int result = goodsMapper.addGoods(goodsInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
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
