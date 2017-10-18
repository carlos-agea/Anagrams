package com.carlos.controller;

import com.carlos.service.AnagramService;
import com.carlos.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anagram")
public class AnagramController {

    private AnagramService anagramService;
    private CacheService cacheService;

    @Autowired
    public void setAnagramService(AnagramService anagramService, CacheService cacheService) {
        this.anagramService = anagramService;
        this.cacheService = cacheService;
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public List<String> getAnagram(@PathVariable("word") String word) {
        return cacheService.getWords(anagramService.calculateAnagramKey(word));
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.POST)
    public List<String> setAnagram(@PathVariable("word") String word) {
        cacheService.write(anagramService.calculateAnagramKey(word), word);
        return cacheService.getWords(anagramService.calculateAnagramKey(word));
    }

}
