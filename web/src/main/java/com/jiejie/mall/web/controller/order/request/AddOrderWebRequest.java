package com.jiejie.mall.web.controller.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author linseven
 * @Date 2020/5/24
 */
@Data
public class AddOrderWebRequest extends BaseRequest {
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
    private List<AddGoodsOrderWebRequest> goodsOrderInfoList;


}
