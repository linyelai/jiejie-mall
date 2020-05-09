package com.jiejie.mall.brand;

import com.jiejie.mall.brand.request.BrandPageRequest;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class BrandTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.brand",check = false)
    private BrandService brandService;
    @Test
    public void addBrand(){

        BrandRequest request = new BrandRequest();
        request.setBrandName("华为");
        request.setBrandDesc("华为");
        request.setBrandImg("111");
        Response<Boolean> response =  brandService.addBrand(request);
       System.out.println(response.getData());
    }

    @Test
    public void findBrand(){

        BrandPageRequest request = new BrandPageRequest();
        request.setBrandName("华为");
        request.setCurrentPage(1);
        request.setPageSize(20);
        PageResponse<BrandResponse> response =  brandService.findBrand(request);
        System.out.println(response.getData());
    }

    @Test
    public void findBrandById(){

        BrandRequest request = new BrandRequest();
        request.setBrandName("华为");
        request.setId(1);
        Response<BrandResponse> response =  brandService.findBrandById(request);
        System.out.println(response.getData());
    }

    @Test
    public void updateBrand(){

        BrandRequest request = new BrandRequest();
        request.setBrandName("华为");
        request.setBrandDesc("华为1");
        request.setBrandImg("111");
        request.setId(1);
        Response<Boolean> response =  brandService.updateBrand(request);
        System.out.println(response.getData());
    }

}

