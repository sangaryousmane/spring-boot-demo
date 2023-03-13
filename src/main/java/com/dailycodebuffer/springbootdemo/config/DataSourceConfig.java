package com.dailycodebuffer.springbootdemo.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource dataSource(){
        DataSourceBuilder<?> dataSourceBuilder= DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/practice_db");
        dataSourceBuilder.username("root");
        return dataSourceBuilder.build();
    }

}
//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
//https://youtu.be/SvFXPsmh600
