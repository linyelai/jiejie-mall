package com.jiejie.mall.product;

import com.jiejie.mall.product.model.dbparam.ProductPageParam;
import com.jiejie.mall.product.mapper.GoodsMapper;
import com.jiejie.mall.product.mapper.ProductMapper;
import com.jiejie.mall.product.model.GoodsInfo;
import com.jiejie.mall.product.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author linseven
 * @Date 2020/5/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})// 指定启动类
public class ProductTest {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private  ProductMapper productMapper;

    @Test
    public void findGoodsByPage(){

        Map param = new HashMap<>();
        param.put("productName","华为");
        param.put("shopId",1);
        param.put("offset",0);
        param.put("count",20);
        param.put("status",0);
        param.put("startTime","2020-05-03 00:00:00");
        param.put("endTime","2020-05-05 00:00:00");
        List<GoodsInfo> goodsInfoLis= goodsMapper.findGoodsByPage(param);
        goodsInfoLis.forEach(item->{
            System.out.println(item.getGoodsName());
        });
    }

    @Test
    public void findGoodsById(){

       GoodsInfo goodsInfo= goodsMapper.findGoodsById(1);
        System.out.println(goodsInfo.getGoodsName());

    }


    @Test
    public void updateGoodsTest(){

        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setProductId(1);
        goodsInfo.setGoodsName("华为p30");
        goodsInfo.setId(1);
        Integer num = goodsMapper.updateGoods(goodsInfo);
        System.out.println(num);

    }

    @Test
    public void deleteGoodsTest(){
        Integer num = goodsMapper.deleteGoods(1);
        System.out.println(num);

    }

    @Test
    public void findProductByPage(){
        Map param = new HashMap<>();
        param.put("productName","华为");
        param.put("shopId",1);
        param.put("offset",0);
        param.put("count",20);
        param.put("status",0);
        List<ProductInfo> goodsInfoLis= productMapper.findProductByPage(param);
        goodsInfoLis.forEach(item->{
            System.out.println(item.getProductName());
        });
    }

    @Test
    public void findProductById(){
        ProductInfo productInfo= productMapper.findProductById(1);
        System.out.println(productInfo.getProductName());
    }

    @Test
    public void updateProduct(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("华为p30");
        productInfo.setId(1);
        Integer num = productMapper.updateProduct(productInfo);
        System.out.println(num);


    }

    @Test
    public void deleteProductTest(){
        Integer num = productMapper.deleteProduct(1);
        System.out.println(num);

    }

}
