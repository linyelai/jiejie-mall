package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/5/26
 */
@Data
public class OrderPageRequest extends PageRequest {
        private String orderSn;
        private int status;
        private Integer sellerId;
        private String startTime;
        private String endTime;
}
