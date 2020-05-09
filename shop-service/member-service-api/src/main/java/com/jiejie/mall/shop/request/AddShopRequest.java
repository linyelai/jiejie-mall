package com.jiejie.mall.shop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddShopRequest implements  Serializable  {
    private String shopName;
    private String password;

  }
