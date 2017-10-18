package com.carlos.service;

import java.util.List;
import java.util.stream.Stream;

public interface CacheService {
    List<String> getWords(String anagramKey);
    void updateAnagram(String anagramKey, String word);
    void loadWordsDictionary(Stream<String> linesStream);
}
