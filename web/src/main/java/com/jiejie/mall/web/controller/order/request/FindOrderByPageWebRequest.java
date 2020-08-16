package com.jiejie.mall.web.controller.order.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FindOrderByPageWebRequest  implements Serializable {
    private String orderSn;
    private String reciever;
    private String recieverPhone;
    private Integer status;
    private Date startTime;
    private Date endTime;
}
