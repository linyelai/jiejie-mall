package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class GoodsPageRequest extends PageRequest {

    private String goodsName;
    private Integer shopId;
    private Integer status;
    private String startTime;
    private String endTime;

}
