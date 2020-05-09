package com.jiejie.mall.brand.model;

import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@Data
public class CategoryInfo {

    private Integer id;
    private String categoryName;
    private String categoryDesc;
    private Integer parentId;
    private Integer status;
    private String updateTime;
    private String categoryImg;

}
