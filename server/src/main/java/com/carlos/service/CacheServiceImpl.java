package com.carlos.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

@Service
public class CacheServiceImpl implements CacheService {

    private ConcurrentMap<String, List<String>> cache;
    private AnagramService anagramService;
    private DataService dataService;

    public CacheServiceImpl(AnagramService anagramService, DataService dataService) {
        this.anagramService = anagramService;
        this.dataService = dataService;
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
                if(!v.contains(word)) v.add(word);
                return v;
            }
        });
    }

    @Override
    public void write(String anagramKey, String word) {
        this.updateAnagram(anagramKey, word);
        persist(word);
    }
    public void loadWordsDictionary(Stream<String> linesStream) {
        linesStream
                .forEach(word -> updateAnagram(anagramService.calculateAnagramKey(word), word));
    }

    private void persist(String word) {
        this.dataService.write(word);
    }
}
