package com.jiejie.mall.product;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddGoodsRequest;
import com.jiejie.mall.product.request.GoodsPageRequest;
import com.jiejie.mall.product.request.GoodsRequest;
import com.jiejie.mall.product.request.UpdateGoodsRequest;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/7/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
@Slf4j
public class GoodsTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.product",check = false)
    private GoodsService goodsService;

    @Test
    public void addGoods(){
        AddGoodsRequest request = new AddGoodsRequest();
        Date now = new Date();
        request.setGoodsImgs("http://localhost:8080/1.png");
        request.setGoodsName("橘子");
        BigDecimal price = new BigDecimal(10);
        BigDecimal sellPrice = new BigDecimal(20);
        request.setGoodsPrice(price);
        request.setGoodsSellPrice(sellPrice);
        request.setGoodsSku("sku10001");
        request.setProductId(58);
        request.setStock(10);
        request.setDescription("this is new goods");
        Response<Boolean> response = goodsService.addGoods(request);
        log.info("{}",response.toString());
    }

    @Test
    public void updateGoods(){
        UpdateGoodsRequest request = new UpdateGoodsRequest();
        Date now = new Date();
        request.setGoodsImgs("http://localhost:8080/2.png");
        request.setGoodsName("橘子");
        BigDecimal price = new BigDecimal(10);
        BigDecimal sellPrice = new BigDecimal(20);
        request.setGoodsPrice(price);
        request.setGoodsSellPrice(sellPrice);
        request.setGoodsSku("sku10001");
        request.setProductId(58);
        request.setStock(10);
        request.setDescription("this is new goods");
        request.setId(18);
        Response<Boolean> response = goodsService.updateGoods(request);
        log.info("{}",response.toString());
    }

    @Test
    public void findGoods(){
        GoodsRequest request = new GoodsRequest();
        request.setGoodsName("橘子");
        request.setGoodsSku("sku10001");
        request.setProductId(58);
        request.setId(18);
        Response<GoodsResponse> response = goodsService.findGoods(request);
        log.info("{}",response.toString());
    }

    @Test
    public void findGoodsByPage(){
        GoodsPageRequest request = new GoodsPageRequest();
        request.setGoodsName("橘子");
        request.setCurrentPage(1);
        request.setPageSize(20);
        PageResponse<GoodsResponse> response = goodsService.findGoodsByPage(request);
        log.info("{}",response.toString());
    }



}
