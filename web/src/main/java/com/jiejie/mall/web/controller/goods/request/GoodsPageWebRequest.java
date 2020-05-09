package com.jiejie.mall.web.controller.goods.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author linseven
 * @Date 2020/5/6
 */
@Data
public class GoodsPageWebRequest extends PageRequest {
    private String goodsName;
    private String sku;
    private String spu;
    private String startTime;
    private String endTime;
    private Integer shopId;
}
