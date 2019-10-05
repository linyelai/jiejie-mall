package com.jiejie.mall.web.controller.response;

import lombok.Data;

@Data
public class CommonWebResponse<T> {
    T result;
}
