package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author linseven
 * @Date 2020/5/26
 */
@Data
public class OrderPageRequest extends PageRequest implements Serializable {
        private String orderSn;
        private int status;
        private Integer sellerId;
        private String startTime;
        private String endTime;
}
