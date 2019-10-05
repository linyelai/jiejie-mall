package com.jiejie.mall.member.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberInfoResponse implements Serializable {
    private final  static long id = 1L;
    private String memberName;
    private String password;
}
