package com.jiejie.mall.order.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse extends BaseResponse {
    private Integer id;
    private Integer shopId;
    private String orderNum;
    private String mainOrderNum;
    private BigDecimal totalMoney;
}
