package SherlockAndAnagrams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SherlockAndAnagrams {

    //https://www.hackerrank.com/challenges/sherlock-and-anagrams/

    // Complete the sherlockAndAnagrams function below.
    public static int sherlockAndAnagrams(String word) {
        Map<String, Integer> substrings = splitToSubstrings(word);
        return 1;

    }

    private static Map<String, Integer> splitToSubstrings(String word) {
        Map<String, Integer> substrings = new HashMap<>();
        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j <= word.length() - i; j++) {
                String subString = word.substring(j, j + i);
                substrings.compute(subString, (key, value) -> value != null ? value + 1 : 1);
            }
        }
        return substrings;
    }


}
