package com.jiejie.mall.brand.request;

import lombok.Data;

import java.util.List;

/**
 * @Author linseven
 * @Date 2020/8/22
 */
@Data
public class DeleteBrandRequest {
    private List<Integer> ids;
}
