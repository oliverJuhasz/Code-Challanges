package SparseArrays;

import java.util.HashMap;

public class SparseArrays {

    //https://www.hackerrank.com/challenges/sparse-arrays/problem

    public static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> counter = new HashMap<>();
        int[] results = new int[queries.length];
        for (String word : strings) {
            counter.compute(word, (key, value) -> counter.containsKey(word) ? value + 1 : 1);
        }
        for (int i = 0; i < queries.length; i++) {
            results[i] = counter.getOrDefault(queries[i], 0);
        }
        return results;
    }

    public static int[] matchingStringsNaive(String[] strings, String[] queries) {
        int[] results = new int[queries.length];
        int resultIndex = 0;
        for (String query : queries) {
            int occurances = 0;
            for (String word : strings) {
                if (query.equals(word)) {
                    occurances++;
                }
            }
            results[resultIndex] = occurances;
            resultIndex++;
        }
        return results;
    }
}
