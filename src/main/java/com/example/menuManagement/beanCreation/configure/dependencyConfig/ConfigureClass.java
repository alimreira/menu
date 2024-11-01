package com.example.menuManagement.beanCreation.configure.dependencyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureClass {

    @Bean(name ="source")
    public DataSourcing dataSource () {
        DataSourcing ds = new DataSourcing("url",16);
        return ds;
    }

    @Bean
    public TransactionMgr transactionMgr () {
        TransactionMgr mgr = new TransactionMgr(dataSource());
        return mgr;
    }
}
