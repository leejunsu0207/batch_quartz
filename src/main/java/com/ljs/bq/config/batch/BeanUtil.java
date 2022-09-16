package com.ljs.bq.config.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil {

    ApplicationContext applicationContext;

    public BeanUtil(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Object getBean(String name){
        return applicationContext.getBean(name);
    }

}
