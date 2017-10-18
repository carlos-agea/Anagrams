package com.carlos;

import com.carlos.service.CacheService;
import com.carlos.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

@SpringBootApplication
public class Application implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DataService dataService;

    @Autowired
    private CacheService cacheService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            cacheService.loadWordsDictionary(dataService.loadWords());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
