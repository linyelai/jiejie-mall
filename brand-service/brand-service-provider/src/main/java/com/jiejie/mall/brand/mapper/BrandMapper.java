package com.jiejie.mall.brand.mapper;

import com.jiejie.mall.brand.model.BrandInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandMapper {
    public int addBrand(BrandInfo brandInfo);
    public int updateBrand(BrandInfo brandInfo);
    public List<BrandInfo> findBrandByPage(Map param);
    public BrandInfo findBrandById(Integer id);
    public int count(Map param);
}