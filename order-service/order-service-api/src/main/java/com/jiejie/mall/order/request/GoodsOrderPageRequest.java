package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class GoodsOrderPageRequest extends PageRequest {
    private  Integer id;
    private String orderNum;
    private String goodOrderNum;
    private String productName;

}
