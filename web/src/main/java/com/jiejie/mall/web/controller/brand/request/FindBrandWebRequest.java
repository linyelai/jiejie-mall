package com.jiejie.mall.web.controller.brand.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class FindBrandWebRequest  extends BaseRequest {
    private String brandName;
}
