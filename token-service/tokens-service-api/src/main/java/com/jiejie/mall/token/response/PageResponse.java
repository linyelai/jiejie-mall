package com.jiejie.mall.token.response;

import lombok.Data;

@Data
public class PageResponse extends  BaseResponse {
    private  int pageSize;
    private int currentPage;
}
