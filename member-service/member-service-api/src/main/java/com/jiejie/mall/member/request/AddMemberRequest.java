package com.jiejie.mall.member.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AddMemberRequest implements Serializable {
    private final  static long id = 1L;
    private String memberName;
    private String password;
  }
