package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.util.Date;

@Data
public class GoodsOrderRequest extends BaseRequest {

    private  Integer id;
    private String orderNum;
    private String goodOrderNum;
    private String productName;


}
