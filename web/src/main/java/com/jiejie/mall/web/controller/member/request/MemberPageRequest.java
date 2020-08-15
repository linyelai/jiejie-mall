package com.jiejie.mall.web.controller.member.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/5/12
 */
@Data
public class MemberPageRequest extends PageRequest {
    private String memberName;
}
