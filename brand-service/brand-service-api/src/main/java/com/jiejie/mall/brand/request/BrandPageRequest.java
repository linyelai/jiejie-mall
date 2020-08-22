package com.jiejie.mall.brand.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/8/22
 */
@Data
public class BrandPageRequest extends PageRequest {
    private String brandName;
}
