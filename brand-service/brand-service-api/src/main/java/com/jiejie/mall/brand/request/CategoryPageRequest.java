package com.jiejie.mall.brand.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@Data
public class CategoryPageRequest extends PageRequest{
    private Integer id;

    private String categoryName;

    private String categoryDesc;

    private String categoryImg;
}
