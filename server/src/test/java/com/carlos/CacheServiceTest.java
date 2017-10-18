package com.carlos;

import com.carlos.service.AnagramService;
import com.carlos.service.CacheService;
import com.carlos.service.CacheServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CacheServiceTest {

    private CacheService cacheService;

    @Mock
    private AnagramService anagramServiceMock;

    @Before
    public void setUp() {
        cacheService = new CacheServiceImpl(anagramServiceMock);
    }

    @Test
    public void updateAnagram_shouldUpdateAndRetrieveWordsInCache() {
        // When
        cacheService.updateAnagram("abc", "bca");
        cacheService.updateAnagram("abc", "cba");

        // Then
        Assert.assertEquals(cacheService.getWords("abc").size(), 2);
        Assert.assertTrue(cacheService.getWords("abc").contains("bca"));
        Assert.assertTrue(cacheService.getWords("abc").contains("cba"));
    }


}
