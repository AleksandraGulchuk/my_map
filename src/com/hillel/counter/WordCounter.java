package com.hillel.counter;

import com.hillel.data_structures.MyMap;

import java.util.Locale;


public class WordCounter {

    private final String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public MyMap<String, Integer> getWordsMap() {
        String[] words = text.toLowerCase(Locale.ROOT).split("[,.:;!?]?\\s");
        MyMap<String, Integer> wordsMap = new MyMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, (wordsMap.get(word) + 1));
            } else wordsMap.put(word, 1);
        }
        return wordsMap;
    }

}
