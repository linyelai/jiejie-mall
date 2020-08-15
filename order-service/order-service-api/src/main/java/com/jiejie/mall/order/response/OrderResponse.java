package com.jiejie.mall.order.response;

import com.jiejie.mall.common.response.BaseResponse;
import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponse extends BaseResponse {
    private Integer id;
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
