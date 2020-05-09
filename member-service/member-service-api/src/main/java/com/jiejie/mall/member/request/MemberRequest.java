package com.jiejie.mall.member.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class MemberRequest extends BaseRequest {

    private String memberName;
    private Integer id;
}
