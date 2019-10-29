package com.jiejie.mall.order.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MainOrderResponse  extends BaseResponse{
    private  Integer id;
    private String mainOrderNum;
    private Integer memberId;
    private BigDecimal totalMongy;
    private Integer status;
    private Date createTime;
}
