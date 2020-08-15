package com.jiejie.mall.web.domain;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private List<Role> roles;
    private String url;
}
