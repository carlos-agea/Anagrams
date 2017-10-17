package com.carlos.service;

import java.util.List;

public interface FileService {
    List<String> loadWords(String path);
    void updateWords(List<String> words, String path);
}
