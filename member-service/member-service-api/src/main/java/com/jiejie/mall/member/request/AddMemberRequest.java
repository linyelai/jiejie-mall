package com.jiejie.mall.member.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
public class AddMemberRequest extends BaseRequest  {
    @NonNull
    private String memberName;
    @NonNull
    private String password;

  }
