package com.jiejie.mall.auth.model;

import lombok.Data;

@Data
public class RolePageParam extends RoleInfo {

    private Integer currentPage;

    private Integer pageSize;
}
