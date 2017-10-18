package com.carlos.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    @Value("${words.file_path}")
    private String filePath;

    @Override
    public Stream<String> loadWords() throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    @Override
    public void updateWords(List<String> words) {
        //TODO
    }
}
