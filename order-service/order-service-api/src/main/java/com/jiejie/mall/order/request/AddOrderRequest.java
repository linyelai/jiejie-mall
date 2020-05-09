package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddOrderRequest extends BaseRequest {

    private Integer id;
    private String orderSn;
    private BigDecimal totalMoney;
    private Integer status;
    private String createTime;
    private Integer productId;
    private AddGoodsOrderRequest goods;
    private Integer shopId;
    private Integer memberId;


}
