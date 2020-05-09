package com.jiejie.mall.product.mapper;

import com.jiejie.mall.product.model.dbparam.ProductPageParam;
import com.jiejie.mall.product.model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    public int addProduct(ProductInfo productInfo);

    public ProductInfo findProductById(Integer  id);

    public List<ProductInfo> findProductByPage(Map param);

    public int updateProduct(ProductInfo request);

    public int  deleteProduct(Integer id);

}
