package SherlockAndAnagrams;

import java.util.*;

public class SherlockAndAnagrams {

    //https://www.hackerrank.com/challenges/sherlock-and-anagrams/

    // Complete the sherlockAndAnagrams function below.
    public static int sherlockAndAnagrams(String word) {
        int numberOfPossibleAnagrams = 0;
        for (int step = 1; step < word.length(); step++) {
            Map<HashMap<Character, Integer>, Integer> candidates = new HashMap<>();
            for (int i = 0; i < word.length() - step + 1; i++) {
                Map<Character, Integer> keyMap2 = convertToKeyMap(word.substring(i, i + step));
                if (candidates.containsKey(keyMap2)) {
                    numberOfPossibleAnagrams += candidates.get(keyMap2);
                    candidates.compute((HashMap<Character, Integer>) keyMap2, (key, value) -> value + 1);
                } else {
                    candidates.put((HashMap<Character, Integer>) keyMap2, 1);
                }
            }

        }
        return numberOfPossibleAnagrams;
    }

    private static Map<Character, Integer> convertToKeyMap(String subString) {
        Map<Character, Integer> keyMap = new HashMap<>();
        for (char character : subString.toCharArray()) {
            keyMap.compute(character, (key, value) -> value == null ? 1 : value + 1);
        }
        return keyMap;



    }

}
