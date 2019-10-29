package com.jiejie.mall.common.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse <T>extends  BaseResponse {

    private int currentPage;
    private int pageSize;
    private List<T> data;
    private Integer total;
    private Integer totalPage;
}
