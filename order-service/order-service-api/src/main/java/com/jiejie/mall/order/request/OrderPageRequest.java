package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.util.Date;

@Data
public class OrderPageRequest extends PageRequest {
    private  Integer id;
    private Integer shopId;
    private String orderNum;
    private String mainOrderNum;
    private Integer status;
    private Date startTime;
    private Date endTime;
}
