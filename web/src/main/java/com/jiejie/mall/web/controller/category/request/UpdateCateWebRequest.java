package com.jiejie.mall.web.controller.category.request;

import com.jiejie.mall.token.request.BaseRequest;
import lombok.Data;

@Data
public class UpdateCateWebRequest  extends BaseRequest {
    private Integer id;
    private String cateName;
    private String desc;

}
