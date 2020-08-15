package com.jiejie.mall.web.controller.brand.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class AddBrandWebRequest extends BaseRequest {
    private String brandName;
    private String img;
    private String desc;
}
