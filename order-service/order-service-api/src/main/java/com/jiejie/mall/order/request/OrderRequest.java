package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderRequest extends BaseRequest implements Serializable {

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
