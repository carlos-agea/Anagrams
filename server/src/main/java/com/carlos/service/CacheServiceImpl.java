package com.carlos.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

@Service
public class CacheServiceImpl implements CacheService {

    private ConcurrentMap<String, List<String>> cache;
    private AnagramService anagramService;

    public CacheServiceImpl(AnagramService anagramService) {
        this.anagramService = anagramService;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public List<String> getWords(String anagramKey) {
        return this.cache.get(anagramKey);
    }

    @Override
    public void updateAnagram(String anagramKey, String word) {
        cache.compute(anagramKey, (k, v) -> {
            if (v == null) {
                List<String> words = new ArrayList<>();
                words.add(word);
                return words;
            } else {
                v.add(word);
                return v;
            }
        });
    }

    public void loadWordsDictionary(Stream<String> linesStream) {
        linesStream
                .forEach(word -> updateAnagram(anagramService.calculateAnagramKey(word), word));
    }

}
