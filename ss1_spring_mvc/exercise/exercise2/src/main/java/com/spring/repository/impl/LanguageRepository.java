package com.spring.repository.impl;

import com.spring.repository.ILanguageRepository;

import java.util.HashMap;

import java.util.Map;

public class LanguageRepository implements ILanguageRepository {
    private static Map<String, String> languageList = new HashMap<>();


    @Override
    public String translate(String english) {

        languageList.put("apple", "quả táo");
        languageList.put("banana", "quả chuối");
        languageList.put("orange", "quả cam");
        languageList.put("water melon", "quả dưa hấu");
        languageList.put("lemon", "quả chanh");
        languageList.put("pineapple", "quả thơm");

        return languageList.get(english);

    }
}
