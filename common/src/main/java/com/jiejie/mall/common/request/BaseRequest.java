package com.jiejie.mall.common.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequest  implements Serializable{
    private final static long id = 1L;
    private Integer userId;//用户id
    private String processId;//处理过程id
}
