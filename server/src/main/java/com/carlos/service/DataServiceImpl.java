package com.carlos.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

@Service
public class DataServiceImpl implements DataService {

    @Value("${words.file_path}")
    private String filePath;

    @Override
    public Stream<String> loadWords() throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    @Override
    public void write(String word) {
        try {
            Files.write(Paths.get(filePath), (word + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
