package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderRequest extends BaseRequest {

    private  Integer id;
    private Integer shopId;
    private String orderNum;
    private String mainOrderNum;
    private Integer status;
    private  Date startTime;

    private Date endTime;

}
