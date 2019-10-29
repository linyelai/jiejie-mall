package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.util.Date;

@Data
public class MainOrderRequest extends BaseRequest {

    private Integer id;
    private String mainOrderNum;
    private Integer memberId;
    private Date startTime;
    private Date endTime;
}
