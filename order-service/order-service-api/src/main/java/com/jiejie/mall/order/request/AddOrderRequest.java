package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AddOrderRequest extends BaseRequest {

    private String orderSn;
    private Integer shopId;
    private Integer memberId;
    private String reciever;
    private String recieverPhone;
    private String shopName;
    private String memberName;
    private BigDecimal totalMoney;
    private Integer status;
    private String createTime;
    private List<AddGoodsOrderRequest> goodsOrderInfoList;


}
