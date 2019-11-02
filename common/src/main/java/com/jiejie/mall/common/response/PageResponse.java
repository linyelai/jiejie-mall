package com.jiejie.mall.common.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse <T>extends  BaseResponse {

    protected int currentPage;
    protected int pageSize;
    protected List<T> data;
    protected Integer total;
    protected Integer totalPage;
}
