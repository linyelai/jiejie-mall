package com.jiejie.mall.brand.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

@Data
public class BrandResponse  extends BaseResponse{
    private int id;
    private String brandName;
    private String desc;
    private String img;
}
