package com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnagramServiceImpl implements AnagramService {

    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public List<String> getAnagrams(String word) {
        return fileService.loadWords(word);
    }

    @Override
    public void updateAnagram(String word) {

    }
}
