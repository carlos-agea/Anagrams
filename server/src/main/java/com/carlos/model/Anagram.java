package com.carlos.model;

import java.util.List;

public class Anagram {
    private String anagramKey;
    private List<String> anagrams;

    public Anagram(String anagramKey) {
        this.anagramKey = anagramKey;
    }

    public void addAnagram(String word) {
        this.anagrams.add(word);
    }

    public String getAnagramKey() {
        return anagramKey;
    }

    public List<String> getAnagrams() {
        return anagrams;
    }

}
