package com.jiejie.mall.brand.response;

import lombok.Data;

@Data
public class CategoryResponse {
    private Integer id;
    private String categoryName;
    private String categoryDesc;
    private String categoryImg;
    private Integer status;

}
