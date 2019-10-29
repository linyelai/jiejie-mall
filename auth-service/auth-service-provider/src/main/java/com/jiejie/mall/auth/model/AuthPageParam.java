package com.jiejie.mall.auth.model;

import lombok.Data;

@Data
public class AuthPageParam extends AuthInfo {
    private Integer currentPage;
    private Integer pageSize;

}
