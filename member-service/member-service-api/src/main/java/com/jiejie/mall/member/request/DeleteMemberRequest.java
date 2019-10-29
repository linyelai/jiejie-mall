package com.jiejie.mall.member.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class DeleteMemberRequest extends BaseRequest {
    private Integer id;
}
