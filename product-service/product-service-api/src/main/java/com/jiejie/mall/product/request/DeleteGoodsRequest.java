package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class DeleteGoodsRequest extends BaseRequest {
    private  Integer id;
}
