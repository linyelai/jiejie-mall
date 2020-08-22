package com.jiejie.mall.brand.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/8/17
 */
@Data
public class CategoryInfo {

    private Integer id;
    private Integer parentId;
    private String categoryName;
    private String categoryImg;
    private String categoryDesc;
    private Date updateTime;
}
