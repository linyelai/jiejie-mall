package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderRequest extends BaseRequest {

    private Integer id;
    private String orderSn;
    private String productName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalMoney;
    private Integer status;
    private String reciever;
    private String recieverPhone;
    private Date startTime;
    private Date endTime;

}
