package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddOrderRequest extends BaseRequest {

    private Integer shopId;
    private String orderNum;
    private String mainOrderNum;
    private BigDecimal totalMoney;


}
