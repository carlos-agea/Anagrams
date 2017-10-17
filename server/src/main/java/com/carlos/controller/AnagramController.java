package com.carlos.controller;

import com.carlos.service.AnagramService;
import com.carlos.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anagram")
public class AnagramController {

    private AnagramService anagramService;

    @Autowired
    public void setAnagramService(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public List<String> getAnagram(@PathVariable("word") String word) {
        return anagramService.getAnagrams(word);
    }


}
