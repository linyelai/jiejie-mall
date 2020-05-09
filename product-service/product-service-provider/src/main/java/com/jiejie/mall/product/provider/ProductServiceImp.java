package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.model.dbparam.ProductPageParam;
import com.jiejie.mall.product.mapper.ProductMapper;
import com.jiejie.mall.product.model.ProductInfo;
import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.request.DeleteProductRequest;
import com.jiejie.mall.product.request.ProductPageRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.ProductResponse;
import com.jiejie.mall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public Response<Boolean> addProduct(AddProductRequest request){

        Response<Boolean> response = new Response<>();
        ProductInfo productInfo = BeanCopyUtil.copyProperties(ProductInfo.class,request);
        int result = productMapper.addProduct(productInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return  response;
    }

    public Response<ProductResponse> findProduct(ProductRequest request){
        Response<ProductResponse> response = new Response<>();
        Integer id = request.getId();
        ProductInfo productInfo = productMapper.findProductById(id);
        ProductResponse productResponse = BeanCopyUtil.copyProperties(ProductResponse.class,productInfo);
        response.setData(productResponse);
        response.setSuccess(true);
        return response;
    }

    public PageResponse<ProductResponse> findProductByPage(ProductPageRequest request){

        Map param = new HashMap<>();
        param.put("productName",request.getProductName());
        param.put("shopId",request.getShopId());
        param.put("offset",request.getPageSize()*(request.getCurrentPage()-1));
        param.put("count",request.getPageSize());
        param.put("status",request.getStatus());
        List<ProductInfo> productInfoList = productMapper.findProductByPage(param);
        List<ProductResponse> productResponseList = BeanCopyUtil.copyList(ProductResponse.class,productInfoList);
        PageResponse<ProductResponse> response = new PageResponse<>();
        response.setData(productResponseList);
        return response;
    }

    public Response<Boolean> updateProduct(ProductRequest request){

        Response<Boolean> response = new Response<>();
        ProductInfo productInfo = BeanCopyUtil.copyProperties(ProductInfo.class,request);
        int result = productMapper.updateProduct(productInfo);
        if(result>0){
            response.setData(true);
        }else {
            response.setData(false);
        }
        return null;
    }

    public Response<Boolean> deleteProduct(DeleteProductRequest request){

        Response<Boolean> response = new Response<>();
        Integer id = request.getId();
        int result = productMapper.deleteProduct(id);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }

}
