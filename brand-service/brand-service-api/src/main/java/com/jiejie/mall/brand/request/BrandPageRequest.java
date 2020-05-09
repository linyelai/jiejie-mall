package com.jiejie.mall.brand.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class BrandPageRequest  extends PageRequest{

    private int id;

    private String brandName;

    private String desc;
}
