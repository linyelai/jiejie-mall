package com.jiejie.mall.product;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.request.DeleteProductRequest;
import com.jiejie.mall.product.request.ProductPageRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.ProductResponse;
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
public class ProductTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.product",check = false)
    private ProductService productService;

    @Test
    public void addProduct(){
        AddProductRequest request = new AddProductRequest();
        Date now = new Date();
        request.setCreateTime(now);
        BigDecimal discount = new BigDecimal(80);
        request.setDiscount(discount);
        request.setProductBrandId(1);
        request.setProductCateId(1);
        request.setProductMainImg("http://www.baidu.com");
        request.setProductName("橘子");
        request.setProductSpu("spu100001");
        request.setShopId(1);
        request.setStatus(1);
        request.setUpdateTime(now);
        request.setDescription("test");
        Response<Boolean> response = productService.addProduct(request);

    }

    @Test
    public  void findProduct(){

        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(58);
        Response<ProductResponse> productResponse =  productService.findProduct(productRequest);
        log.info("product:{}",productResponse.toString());
    }

    @Test
    public void findProductByPage(){
        ProductPageRequest productPageRequest = new ProductPageRequest();
        productPageRequest.setCurrentPage(1);
        productPageRequest.setShopId(1);
        productPageRequest.setPageSize(20);
        PageResponse<ProductResponse> response = productService.findProductByPage(productPageRequest);
        log.info("{}",response.toString());
    }

    @Test
    public void findProductBySpu(){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductSpu("spu100001");
        Response<ProductResponse> response = productService.findProduct(productRequest);
        log.info("{}",response.toString());
    }
    @Test
    public void updateProduct(){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(58);
        productRequest.setDescription("this is a test product");
        Response<Boolean> response = productService.updateProduct(productRequest);
        log.info("{}",response.toString());
    }
    @Test
    public void deleteProduct(){
        DeleteProductRequest productRequest = new DeleteProductRequest();
        productRequest.setId(58);
        Response<Boolean> response = productService.deleteProduct(productRequest);
        log.info("{}",response.toString());
    }

}
