package com.jiejie.mall.shardingsphere.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.jiejie.mall.shardingsphere.algorithm.ModuloDatabaseShardingAlgorithm;
import com.jiejie.mall.shardingsphere.algorithm.ModuloTableShardingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Configuration
@EnableConfigurationProperties(ShardDataSourceProperties.class)
public class ShardDataSourceConfig {

    @Autowired
    private ShardDataSourceProperties shardDataSourceProperties;

    private DruidDataSource parentDs() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(shardDataSourceProperties.getDriverClassName());
        ds.setUsername(shardDataSourceProperties.getUsername());
        ds.setUrl(shardDataSourceProperties.getUrl());
        ds.setPassword(shardDataSourceProperties.getPassword());
        ds.setFilters(shardDataSourceProperties.getFilters());
        ds.setMaxActive(shardDataSourceProperties.getMaxActive());
        ds.setInitialSize(shardDataSourceProperties.getInitialSize());
        ds.setMaxWait(shardDataSourceProperties.getMaxWait());
        ds.setMinIdle(shardDataSourceProperties.getMinIdle());
        ds.setTimeBetweenEvictionRunsMillis(shardDataSourceProperties.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(shardDataSourceProperties.getMinEvictableIdleTimeMillis());
        ds.setValidationQuery(shardDataSourceProperties.getValidationQuery());
        ds.setTestWhileIdle(shardDataSourceProperties.isTestWhileIdle());
        ds.setTestOnBorrow(shardDataSourceProperties.isTestOnBorrow());
        ds.setTestOnReturn(shardDataSourceProperties.isTestOnReturn());
        ds.setPoolPreparedStatements(shardDataSourceProperties.isPoolPreparedStatements());
        ds.setMaxPoolPreparedStatementPerConnectionSize(
                shardDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
        ds.setRemoveAbandoned(shardDataSourceProperties.isRemoveAbandoned());
        ds.setRemoveAbandonedTimeout(shardDataSourceProperties.getRemoveAbandonedTimeout());
        ds.setLogAbandoned(shardDataSourceProperties.isLogAbandoned());
        ds.setConnectionInitSqls(shardDataSourceProperties.getConnectionInitSqls());
        return ds;
    }

    private DataSource ds(String url) throws SQLException {
        DruidDataSource ds = parentDs();
        ds.setUsername(shardDataSourceProperties.getUsername1());
        ds.setUrl(url);
        ds.setPassword(shardDataSourceProperties.getPassword1());
        return ds;
    }

    private DataSourceRule dataSourceRule() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>(shardDataSourceProperties.getUrls().size());
        int i = 0 ;
        for(String url: shardDataSourceProperties.getUrls()) {
            dataSourceMap.put("ds_"+i, ds(url));
            i++;
        }
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);
        return dataSourceRule;
    }
    //对order对策略
    private TableRule orderTableRule() throws SQLException {
        List<String> orderTableNames = new ArrayList<>();
        for(int tableIndex= 0 ;tableIndex <shardDataSourceProperties.getOrdertableNum();tableIndex++){
            orderTableNames.add("t_order_"+tableIndex);
        }
        TableRule orderTableRule = TableRule.builder("t_order").actualTables(orderTableNames)
                .dataSourceRule(dataSourceRule()).build();
        return orderTableRule;
    }

    //分库分表策略
    private ShardingRule shardingRule() throws SQLException {
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule())
                .tableRules(Arrays.asList(orderTableRule()))
                .databaseShardingStrategy(
                        new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
                .build();
        return shardingRule;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        return ShardingDataSourceFactory.createDataSource(shardingRule());
    }


    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }
}

