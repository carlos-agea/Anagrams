package com.carlos.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface DataService {
    Stream<String> loadWords() throws IOException;
    void write(String word);
}
