package com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class AnagramServiceImpl implements AnagramService {

    private FileService fileService;

    public AnagramServiceImpl() {
        try {
            loadWordsDictionary(fileService.loadWords());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public List<String> getAnagrams(String word) {
        // TODO
        return Arrays.asList(word);
    }

    @Override
    public void updateAnagram(String word) {

    }

    private void loadWordsDictionary(Stream<String> words) {
        // TODO
    }



}
