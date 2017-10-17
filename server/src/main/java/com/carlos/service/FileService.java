package com.carlos.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface FileService {
    Stream<String> loadWords() throws IOException;
    void updateWords(List<String> words);
}
