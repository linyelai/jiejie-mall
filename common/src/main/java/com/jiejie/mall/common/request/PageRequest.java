package com.jiejie.mall.common.request;

import lombok.Data;

@Data
public class PageRequest extends  BaseRequest {
    protected Integer currentPage;
    protected Integer pageSize;
}
