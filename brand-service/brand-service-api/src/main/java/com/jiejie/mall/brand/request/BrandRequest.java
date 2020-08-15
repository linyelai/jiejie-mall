package com.jiejie.mall.brand.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class BrandRequest  extends BaseRequest{

    private int id;

    private String brandName;

    private String desc;
    private String img;
}
