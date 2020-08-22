package com.jiejie.mall.web.controller.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.util.List;

@Data
public class IdWebRequest extends BaseRequest {

    private List<Integer> ids;
}
