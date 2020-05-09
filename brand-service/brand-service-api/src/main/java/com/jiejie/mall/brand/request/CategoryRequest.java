package com.jiejie.mall.brand.request;

import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@Data
public class CategoryRequest {

    private Integer id;

    private String categoryName;

    private String categoryDesc;

    private String categoryImg;

    private Integer parentId;

}
