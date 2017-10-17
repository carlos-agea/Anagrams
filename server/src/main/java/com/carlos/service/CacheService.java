package com.carlos.service;

import com.carlos.model.Anagram;

import java.util.List;

public interface CacheService {
    Anagram getAnagram(String anagramKey);
    void updateAnagram(String anagram);
}
