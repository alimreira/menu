package com.example.menuManagement.beanCreation.configure;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigRecipe {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Recipe recipe () {
        Recipe one = new Recipe("wheat",14);
        return one;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Recipe recipe1 () {
        Recipe two = new Recipe("oat", 12);
        return two;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public Recipe recipe2 () {
        Recipe three = new Recipe("semolina",18);
        return three;
    }

    @Bean("bean")
    public Recipe recipe3 () {
        Recipe four = new Recipe("milk",20);
        return four;
    }
}
