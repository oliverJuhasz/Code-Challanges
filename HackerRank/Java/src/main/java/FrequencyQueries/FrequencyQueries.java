package FrequencyQueries;

import java.util.*;

public class FrequencyQueries {

    //https://www.hackerrank.com/challenges/frequency-queries/

    public static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> occurances = new HashMap<>();
        int xyz = 0;
        List<Integer> results = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            xyz++;
            int command = query[0];
            int number = query[1];
            if (command == 1) {
                if (counter.get(number) == null) {
                    counter.put(number, 1);
                    occurances.compute(1, (key, value) -> value != null ? value + 1 : 1);
                } else {
                    int frequency = counter.get(number);
                    counter.put(number, frequency + 1);
                    occurances.compute(frequency, (key, value) -> value - 1);
                    occurances.compute(frequency + 1, (key, value) -> value != null ? value + 1 : 1);
                }
            } else if (command == 2) {
                Integer occurrenceToRemove = counter.get(number);
                if (occurrenceToRemove != null && occurrenceToRemove != 0) {
                    counter.compute(number, (key, value) -> value - 1);
                    occurances.compute(occurrenceToRemove, (key, value) -> value > 0 ? value - 1 : 0);
                    occurances.compute(occurrenceToRemove - 1, (key, value) -> value != null ? value + 1 : 1);
                }
            } else {
                if (occurances.get(number) != null && occurances.get(number) > 0) {
                    results.add(1);
                } else {
                    results.add(0);
                }
            }
        }
        return results;
    }

}
