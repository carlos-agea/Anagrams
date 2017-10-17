package com.carlos.service;

import java.util.List;

public interface AnagramService {
    List<String> getAnagrams(String word);
    void updateAnagram(String word);
}
