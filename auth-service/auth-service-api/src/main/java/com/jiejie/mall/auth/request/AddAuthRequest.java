package com.jiejie.mall.auth.request;
import lombok.Data;

import java.util.Date;

@Data
public class AddAuthRequest {

    private Integer parentId; //父级权限
    private String name;//权限名称
    private String url;//url
    private String resourceId;//资源id
    private Integer type;//类型 0：按钮 1：菜单
    private Integer platform;//平台
    private Integer sort;//排序
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

}
