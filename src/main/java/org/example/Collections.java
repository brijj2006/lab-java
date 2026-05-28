package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Collections {

    public static void main(String[] args) {
        Collections obj = new Collections();
        obj.findFirstNonRepeatingChar();

    }

    //count max occurring character
    public void maxOccurrenceWithoutStreams() {
        String sentence = "find out max occurrence of letter in a sentence";
        sentence = sentence.replaceAll(" ", "");
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : sentence.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Character maxChar = ' ';
        int maxCount = 0;

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("maxChar : " + maxChar);
        System.out.println("maxCount : " + maxCount);
    }

    // find first non-repeating character
    // Use LinkedHashMap when insertion order matters (like first non-repeating character).
    // Use HashMap when only fast lookup is needed (like frequency counting or max repeating character).
    public void findFirstNonRepeatingChar() {
        String sentence = "hello how are you";
        sentence = sentence.replaceAll(" ", "");

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character ch : sentence.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                System.out.println("first non-repeating character is : " + entry.getKey());
                break;
            }
        }
    }

}
