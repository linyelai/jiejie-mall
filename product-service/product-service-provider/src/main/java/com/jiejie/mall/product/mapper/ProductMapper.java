package com.jiejie.mall.product.mapper;

import com.jiejie.mall.product.model.ProductInfo;
import com.jiejie.mall.product.response.ProductResponse;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    public int addProduct(ProductInfo productInfo);

    public ProductInfo findProductById(Integer  id);

    public List<ProductInfo> findProductByPage(Map param);

    public int updateProduct(ProductInfo request);

    public int  deleteProduct(Integer id);

}
