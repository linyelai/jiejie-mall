package com.jiejie.mall.auth.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class RolePageRequest extends PageRequest {
    private Integer id;
    private String name;
    private Integer platform;

}
