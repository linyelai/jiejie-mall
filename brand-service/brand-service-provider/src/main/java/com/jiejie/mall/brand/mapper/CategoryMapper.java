package com.jiejie.mall.brand.mapper;

import com.jiejie.mall.brand.model.CategoryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {

    public int addCategory(CategoryInfo categoryInfo);
    public int updateCategory(CategoryInfo categoryInfo);
    public List<CategoryInfo> findCategoryByPage(Map param);
    public CategoryInfo findCategoryById(Integer id);
    public int count(Map param);
    public int deleteCategory(Integer id);
}
