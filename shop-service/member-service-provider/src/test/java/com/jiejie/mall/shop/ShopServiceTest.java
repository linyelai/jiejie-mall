package com.jiejie.mall.shop;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.shop.request.ShopRequest;
import com.jiejie.mall.shop.response.ShopInfoResponse;
import com.jiejie.mall.shop.service.ShopService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class ShopServiceTest {
    @Reference(version = "1.0.02-SNAPSHOT" ,group = "jiejie.mall.shop",check = false)
    private ShopService shopService;

   @Value("${spring.datasource.url}")
   private String url;
   @Value("${mybatis.type.aliasesPackage}")
    private String typeAliasesPackage;
    @Test
    public void registryMemeber(){
      /*  AddShopRequest request = new AddShopRequest();
        request.setShopName("18312483564");
        request.setPassword("123456");*/
        //shopService.registryShop(request);
      //  shopService.findShopByName("18312483564");

    }
    @Test
    public void findMemeberByNameTest(){
        ShopRequest shopRequest = new ShopRequest();
        shopRequest.setShopName("18312483564");
         Response<ShopInfoResponse> responseResponse =  shopService.findShopByName(shopRequest);
       System.out.println(responseResponse.toString());
       System.out.println(typeAliasesPackage);
    }

    @Test
    public void findMemeberByIdTest(){
        ShopRequest shopRequest = new ShopRequest();
        shopRequest.setShopName("18312483564");
        shopRequest.setId(1);
        Response<ShopInfoResponse> responseResponse =  shopService.findShopById(shopRequest);
        System.out.println(responseResponse.toString());
        System.out.println(typeAliasesPackage);
    }

}
