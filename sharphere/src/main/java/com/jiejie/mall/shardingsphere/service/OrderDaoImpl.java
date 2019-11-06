package com.jiejie.mall.shardingsphere.service;

import com.jiejie.mall.shardingsphere.dao.OrderDao;
import com.jiejie.mall.shardingsphere.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service
public class OrderDaoImpl implements OrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Order> getOrderListByUserId(Integer userId) {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("select order_id, user_id from t_order where user_id=? ");
        return jdbcTemplate.query(sqlBuilder.toString(), new Object[]{userId},
                new int[]{Types.INTEGER}, new BeanPropertyRowMapper<Order>(
                        Order.class));
    }

    @Override
    public void createOrder(Order order) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into t_order(user_id, order_id)");
        sb.append("values(");
        sb.append(order.getUserId()).append(",");
        sb.append(order.getOrderId());
        sb.append(")");
        jdbcTemplate.update(sb.toString());

    }
}

