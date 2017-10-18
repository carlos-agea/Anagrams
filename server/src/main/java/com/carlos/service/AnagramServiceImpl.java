package com.carlos.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public String calculateAnagramKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
