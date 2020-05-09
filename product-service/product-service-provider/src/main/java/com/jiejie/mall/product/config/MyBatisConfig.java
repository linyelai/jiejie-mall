package com.jiejie.mall.product.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.jiejie.mall.product.mapper")
public class MyBatisConfig {

  @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
   @Value("${spring.datasource.url}")
   private String url;
   @Value("${mybatis.mapper-locations}")
   private String mapperLocations;
    @Value("${mybatis.type.aliasesPackage}")
    private String typeAliasesPackage;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName ;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    public DataSource dataSource(){
        return DataSourceBuilder.create().url(url).username(username).password(password).driverClassName(driverClassName).type(dataSourceType).build();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean()throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }




}
