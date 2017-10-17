package com.carlos.service;

import com.carlos.model.Anagram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheServiceImpl implements CacheService {

    private Map<String, Anagram> cache;

    public CacheServiceImpl() {
        this.cache = new HashMap<>();
    }

    @Override
    public Anagram getAnagram(String anagramKey) {
        return this.cache.get(anagramKey);
    }

    @Override
    public void updateAnagram(String word) {

    }
}
