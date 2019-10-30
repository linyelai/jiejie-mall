package com.jiejie.mall.web.controller.product.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FindProductWebRequest extends PageRequest {

    private String productName;//商品名称
    private Integer status;//状态
}
