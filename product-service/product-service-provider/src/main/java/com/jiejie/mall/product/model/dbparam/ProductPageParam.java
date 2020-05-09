package com.jiejie.mall.product.model.dbparam;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/5/6
 */
@Data
public class ProductPageParam {

    private Integer id;
    private String productName;
    private String productSpu;
    private Integer shopId;//商店id
    private Date startTime;
    private Date endTime;
    private Integer status;
    private Integer goodsCateId;//类别id
    private Integer goodsBrandId;//品牌id
    private Integer currentPage;
    private Integer pageSize;
}
