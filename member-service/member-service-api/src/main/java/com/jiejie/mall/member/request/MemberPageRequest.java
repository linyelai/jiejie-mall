package com.jiejie.mall.member.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberPageRequest extends BaseRequest {
    private int currentPage;

    private int pageSize;

    private String memberName;
}
