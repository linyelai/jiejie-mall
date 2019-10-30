package com.jiejie.mall.web.controller.brand.request;

import com.jiejie.mall.token.request.BaseRequest;
import lombok.Data;

@Data
public class UpdateBrandWebRequest  extends BaseRequest {
    private Integer id;
    private String brandName;
    private String desc;
}
