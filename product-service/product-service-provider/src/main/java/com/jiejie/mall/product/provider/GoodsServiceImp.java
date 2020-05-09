package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.mapper.GoodsMapper;
import com.jiejie.mall.product.mapper.GoodsMapper;
import com.jiejie.mall.product.model.GoodsInfo;
import com.jiejie.mall.product.request.AddGoodsRequest;
import com.jiejie.mall.product.request.DeleteGoodsRequest;
import com.jiejie.mall.product.request.GoodsPageRequest;
import com.jiejie.mall.product.request.GoodsRequest;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.stock.request.UpdateStockRequest;
import com.jiejie.mall.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class GoodsServiceImp implements GoodsService {



    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response<Boolean> deleteGooods(DeleteGoodsRequest request) {
        Response<Boolean> response = new Response<>();
        GoodsInfo goodsInfo = BeanCopyUtil.copyProperties(GoodsInfo.class,request);
        int result = goodsMapper.deleteGoods(goodsInfo.getId());
        //保存初始库存
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
    }

    public Response<Boolean> addGoods(AddGoodsRequest request){

        Response<Boolean> response = new Response<>();
        GoodsInfo goodsInfo = BeanCopyUtil.copyProperties(GoodsInfo.class,request);
        int result = goodsMapper.addGoods(goodsInfo);
        //保存初始库存
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
    }


    public PageResponse<GoodsResponse> findGoods(GoodsPageRequest request){

        PageResponse<GoodsResponse> response = new PageResponse<>();
        Map param = new HashMap<>();
        param.put("goodsName",request.getGoodsName());
        param.put("shopId",request.getShopId());
        param.put("offset",request.getPageSize()*(request.getCurrentPage()-1));
        param.put("count",request.getPageSize());
        param.put("status",request.getStatus());
        List<GoodsInfo> goodsInfoList =  goodsMapper.findGoodsByPage(param);
        List<GoodsResponse> goodsResponseList =  BeanCopyUtil.copyList(GoodsResponse.class,goodsInfoList);
        response.setData(goodsResponseList);
        return response;
    }
    @Override
    public Response<GoodsResponse> findById(GoodsRequest request) {
        Response<GoodsResponse> response = new Response<>();
        GoodsInfo goodsInfo =  goodsMapper.findGoodsById(request.getId());
        GoodsResponse goodsResponse=  BeanCopyUtil.copyProperties(GoodsResponse.class,goodsInfo);
        response.setData(goodsResponse);
        return response;
    }
    public Response<Boolean> updateGoods(GoodsRequest request){

        Response<Boolean> response = new Response<>();
        GoodsInfo goodsInfo = BeanCopyUtil.copyProperties(GoodsInfo.class,request);
        int result = goodsMapper.updateGoods(goodsInfo);
        //保存初始库存
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
    }

    public Response<Boolean> deleteGoods(DeleteGoodsRequest request){

        Response<Boolean> response = new Response<>();
        int result = goodsMapper.deleteGoods(request.getId());
        //保存初始库存
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
    }
}
