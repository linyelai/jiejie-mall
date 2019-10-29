package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddMainOrderRequest extends BaseRequest {

    private String mainOrderNum;
    private Integer memberId;
    private BigDecimal totalMongy;
    private Integer status;
    private Date createTime;
}
