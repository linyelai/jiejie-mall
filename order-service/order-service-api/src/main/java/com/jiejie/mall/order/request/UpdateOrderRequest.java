package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class UpdateOrderRequest extends BaseRequest {

    private Integer id;
    private Integer status;

}
