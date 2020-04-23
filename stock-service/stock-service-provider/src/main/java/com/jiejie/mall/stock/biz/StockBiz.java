package com.jiejie.mall.stock.biz;

import com.alibaba.com.caucho.hessian.io.StringValueSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class StockBiz {
    @Autowired
    private ReentrantLock distributeLock;
    @Autowired
    private ValueOperations<String, Object> valueOperations;
    public boolean addStock(String key,int num){

        //获取锁
        try {
            if (distributeLock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
                Integer currentStock = (Integer)valueOperations.get(key);
                valueOperations.set(key,currentStock+num);
            }else{
                //TODO 获得锁超时后要做的事
                log.error("新增库存超时");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            distributeLock.unlock();
        }
        return true;
    }

    public boolean subStock(String key,int num){
        //获取锁
        try {
            if (distributeLock.tryLock(5000L, TimeUnit.MILLISECONDS)) {

                Integer currentStock = (Integer)valueOperations.get(key);
                if((currentStock-num)>=0){
                    valueOperations.set(key,currentStock-num);
                }else{
                    return false;
                }

            }else{
                //TODO 获得锁超时后要做的事
                log.error("新增库存超时");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            distributeLock.unlock();
        }
        return true;
    }

    public boolean setStock(String key,int num){
        //获取锁
        try {
            if (distributeLock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
                valueOperations.set(key,num);
            }else{
                //TODO 获得锁超时后要做的事
                log.error("新增库存超时");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            distributeLock.unlock();
        }
        return true;
    }
}
