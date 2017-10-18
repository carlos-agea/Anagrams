package com.carlos;

import com.carlos.service.CacheService;
import com.carlos.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

@SpringBootApplication
public class Application implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private FileService fileService;

    @Autowired
    private CacheService cacheService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            cacheService.loadWordsDictionary(fileService.loadWords());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
