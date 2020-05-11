package SherlockAndAnagrams;

import java.util.*;

public class SherlockAndAnagrams {

    //https://www.hackerrank.com/challenges/sherlock-and-anagrams/

    // Complete the sherlockAndAnagrams function below.
    public static int sherlockAndAnagrams(String word) {
        int numberOfPossibleAnagrams = 0;

        for (int startPoint = 0; startPoint < word.length(); startPoint++) {
            for (int step = 1; step < word.length(); step++) {
                Map<HashMap<Character, Integer>, Integer> candidates = new HashMap<>();
                for (int i = 0; i < word.length(); i++) {
                    Map<Character, Integer> keyMap = convertToKeyMap(word.substring(i, i + step));
                    if (candidates.containsKey(keyMap)) {
                        numberOfPossibleAnagrams += candidates.get(keyMap);
                        candidates.compute((HashMap<Character, Integer>) keyMap, (key, value) -> value + 1);
                    } else {
                        candidates.put((HashMap<Character, Integer>) keyMap, 1);
                    }
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
