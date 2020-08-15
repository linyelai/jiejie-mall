package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.mapper.GoodsMapper;
import com.jiejie.mall.product.model.GoodsInfo;
import com.jiejie.mall.product.request.*;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.stock.request.UpdateStockRequest;
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

    @Override
    public PageResponse<GoodsResponse> findGoodsByPage(GoodsPageRequest request) {
        PageResponse<GoodsResponse> response = new PageResponse<>();
        int currentPage = request.getCurrentPage();
        int pageSize = request.getPageSize();
        int offset = (currentPage-1)*pageSize;
        String goodsName = request.getGoodsName();
        Integer productId = request.getProductId();
        Map param = new HashMap();
        param.put("offset",offset);
        param.put("pageSize",pageSize);
        param.put("goodsName",goodsName);
        param.put("productId",productId);
        List<GoodsInfo> goodsInfoList =  goodsMapper.findGoodsByPage(param);
        List<GoodsResponse> goodsResponseList = BeanCopyUtil.copyList(GoodsResponse.class,goodsInfoList);
        response.setData(goodsResponseList);
        return response;
    }

    public PageResponse<GoodsResponse> findGoods(GoodsPageRequest request){

        PageResponse<GoodsResponse> response = new PageResponse<GoodsResponse>();
        Map param = new HashMap();
        String goodsName = request.getGoodsName();
        Integer productId = request.getProductId();
        Integer currentPage = request.getCurrentPage();
        Integer pageSize = request.getPageSize();
        param.put("goodsName",goodsName);
        param.put("productId",productId);
        param.put("currentPage",currentPage);
        param.put("pageSize",pageSize);
        List<GoodsInfo> goodsInfoList = goodsMapper.findGoodsByPage(param);
        List<GoodsResponse> goodsResponseList = BeanCopyUtil.copyList(GoodsResponse.class,goodsInfoList);
        response.setData(goodsResponseList);
        return response;
    }

    public Response<Boolean> updateGoods(UpdateGoodsRequest request){

        Response<Boolean> response = new Response<>();
        Integer goodsId = request.getId();
        GoodsInfo updateGoods = BeanCopyUtil.copyProperties(GoodsInfo.class,request);
       GoodsInfo goodsInfo =  goodsMapper.findGoods(updateGoods);
       if(null==goodsInfo){
           response.setData(false);
           response.setErrorMsg("goods does not exist");
           return response;
       }
       int result = goodsMapper.updateGoods(updateGoods);
       if(result<=0){
           response.setData(false);
           response.setErrorMsg("update failed");
       }else{
           response.setData(true);
           response.setErrorMsg("success");
       }
        return  response;
    }

    @Override
    public Response<GoodsResponse> findGoods(GoodsRequest goodsRequest) {

        Response<GoodsResponse> response = new Response<>();
        GoodsInfo goodsInfo = BeanCopyUtil.copyProperties(GoodsInfo.class,goodsRequest);
       GoodsInfo result =  goodsMapper.findGoods(goodsInfo);
       GoodsResponse data = BeanCopyUtil.copyProperties(GoodsResponse.class,result);
       response.setData(data);
        return response;
    }

    @Override
    public Response<Boolean> deleteGoods(DeleteGoodsRequest request) {
        Response<Boolean> response = new Response<>();
        Integer id = request.getId();
       int result =  goodsMapper.deleteGoods(id);
       if(result<=0){
           response.setData(false);
           response.setErrorMsg("delete failed");

       }else{
           response.setData(true);
           response.setErrorMsg("success");
       }
        return response;
    }

}
