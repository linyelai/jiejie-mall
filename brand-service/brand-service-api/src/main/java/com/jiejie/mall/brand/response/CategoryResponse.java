package com.jiejie.mall.brand.response;

import lombok.Data;

import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/8/22
 */
@Data
public class CategoryResponse {

    private Integer id;
    private String categoryName;
    private String categoryDesc;
    private String categoryImg;
    private Date updateTime;
}
