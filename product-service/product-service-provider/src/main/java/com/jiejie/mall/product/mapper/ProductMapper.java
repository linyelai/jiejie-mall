package com.jiejie.mall.product.mapper;

import com.jiejie.mall.product.model.ProductInfo;
import com.jiejie.mall.product.response.ProductResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    public int addProduct(ProductInfo productInfo);

    public ProductInfo findProduct(ProductInfo  productInfo);

     ProductInfo findProductBySpu(@Param(value = "spu") String spu);

    public List<ProductInfo> findProductByPage(Map param);

    public int updateProduct(ProductInfo request);

    public int  deleteProduct(Integer id);

}
