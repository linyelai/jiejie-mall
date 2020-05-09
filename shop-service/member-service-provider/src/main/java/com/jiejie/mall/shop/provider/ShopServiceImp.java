package com.jiejie.mall.shop.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.common.utils.BusinessException;
import com.jiejie.mall.shop.mapper.ShopMapper;
import com.jiejie.mall.shop.model.ShopAllInfo;
import com.jiejie.mall.shop.model.Shop;
import com.jiejie.mall.shop.request.*;
import com.jiejie.mall.shop.response.ShopResponse;
import com.jiejie.mall.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class ShopServiceImp implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    public Response<Boolean> addShop(AddShopRequest request){
        Response<Boolean> response = new Response<Boolean>();
        //查看是否已经存在了该会员
        String shopName = request.getShopName();
        ShopAllInfo shopAllInfo = shopMapper.findShopByName(shopName);
        if(shopAllInfo!=null){
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("该会员已经存在，请换个手机号码注册");
        }else{
            Shop shopInfo = BeanCopyUtil.copyProperties(Shop.class,request);
            int insertRow = shopMapper.addShop(shopInfo);
            if(insertRow<=0){
                log.error("注册会员信息异常，会员手机号码:{}",shopName);
                throw new BusinessException("程序异常");
            }else{
                response.setSuccess(true);
                response.setData(true);
            }
        }
        return response;
    }

    public Response<ShopResponse> findShopByName(ShopRequest request){
        Response<ShopResponse> response =new Response<ShopResponse>();
        ShopAllInfo shopAllInfo = shopMapper.findShopByName(request.getShopName());
        if(shopAllInfo!=null) {
            ShopResponse shopInfoResponse = BeanCopyUtil.copyProperties(ShopResponse.class, shopAllInfo);
            response.setData(shopInfoResponse);
        }else{
            response.setErrorMsg("can not find the shopinfo!");
        }
        return  response;
    }

    public Response<ShopResponse> findShopById(ShopRequest request){
        Response<ShopResponse> response =new Response<ShopResponse>();
        ShopAllInfo shopAllInfo = shopMapper.findShopById(request.getId());
        if(shopAllInfo!=null) {
            ShopResponse shopInfoResponse = BeanCopyUtil.copyProperties(ShopResponse.class, shopAllInfo);
            response.setData(shopInfoResponse);
        }else{
            response.setErrorMsg("can not find the shopinfo!");
        }
        return  response;
    }

    public Response<Boolean> updateShop(UpdateShopRequest request){
        Response<Boolean> response = new Response<Boolean>();
        //查看会员信息是否存在
        Integer id = request.getId();
        if(id!=null) {
            ShopAllInfo oldShopAllInfo = shopMapper.findShopById(id);
            if(oldShopAllInfo==null){
                response.setSuccess(false);
                response.setData(false);
                response.setErrorMsg("更新的会员不存在");
            }
        }else{
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("缺少会员id");
        }
        ShopAllInfo shopAllInfo = BeanCopyUtil.copyProperties(ShopAllInfo.class,request);
        int updateRow = shopMapper.updateShop(shopAllInfo);
        if(updateRow<=0){
            log.error("更新会员信息异常，会员手机号码:{}",request);
            throw new BusinessException("程序异常");
        }else{
            response.setData(true);
            response.setSuccess(true);
        }
        return response;
    }
    public Response<Boolean> deleteShop(DeleteShopRequest request){
        Response<Boolean> response = new Response<Boolean>();
        Integer id = request.getId();
        if(id!=null) {
            ShopAllInfo oldShopAllInfo = shopMapper.findShopById(id);
            if(oldShopAllInfo==null){
                response.setSuccess(false);
                response.setData(false);
                response.setErrorMsg("更新的会员不存在");
            }
        }else{
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("缺少会员id");
        }
        int deleteRow = shopMapper.deleteShop(id);
        if(deleteRow<=0){
            log.error("删除会员信息异常，会员手机号码:{}",request);
            throw new BusinessException("程序异常");
        }else{
            response.setData(true);
            response.setSuccess(true);
        }
        return response;
    }

    public PageResponse<ShopResponse> findShopByPage(ShopPageRequest request){

        return null;
    }

}
