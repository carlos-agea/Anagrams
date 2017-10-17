package com.carlos.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<String> loadWords(String path) {
        return Arrays.asList(path);
    }

    @Override
    public void updateWords(List<String> words, String path) {

    }
}
