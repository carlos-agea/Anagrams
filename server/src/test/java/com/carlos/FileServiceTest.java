package com.carlos;

import com.carlos.service.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Before
    public void setUp() {
        //fileService = new FileServiceImpl();
    }

    @Test
    public void loadWords_shouldLoadWordsInFile() {
        // Given
        Stream<String> wordsStream = null;

        // When
        try {
            wordsStream = fileService.loadWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Then
        Assert.assertEquals(wordsStream.count(), 479623);
    }

}
