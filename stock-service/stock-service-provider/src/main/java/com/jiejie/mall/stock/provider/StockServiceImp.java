package com.jiejie.mall.stock.provider;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.stock.biz.StockBiz;
import com.jiejie.mall.stock.request.UpdateStockRequest;
import com.jiejie.mall.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class StockServiceImp implements StockService {

    @Autowired
    private StockBiz stockBiz;
    public Response<Boolean> updateStock(UpdateStockRequest request){

        Response<Boolean> response = new Response<Boolean>();
        switch ( request.getAction()){
            case 0:
               response.setData(stockBiz.setStock(request.getProductId().toString(),request.getNum()));
               break;
            case 1:
               response.setData(stockBiz.addStock(request.getProductId().toString(),request.getNum()));
               break;
            case 2:
               response.setData( stockBiz.subStock(request.getProductId().toString(),request.getNum()));
               break;
               default:
                    response.setData(false);

        }
        return response;
    }
}
