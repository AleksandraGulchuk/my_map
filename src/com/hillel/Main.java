package com.hillel;

import com.hillel.counter.WordCounter;
import com.hillel.data_structures.MyMap;


public class Main {

    public static void main(String[] args) {

        String text = "Я иду по парку, иду один и вижу как по воде и пробегает луч солнца. ";

        WordCounter wordCounter = new WordCounter(text);
        MyMap<String, Integer> myMap = wordCounter.getWordsMap();

        for (MyMap.Pair<String, Integer> pair : myMap.getPairSet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

    }
}
