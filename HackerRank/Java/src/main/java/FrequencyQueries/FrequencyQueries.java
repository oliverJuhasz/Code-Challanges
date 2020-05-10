package FrequencyQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    //https://www.hackerrank.com/challenges/frequency-queries/

    public static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int command = query[0];
            int number = query[1];
            if (command == 1) {
                counter.compute(number, (key, value) -> value == null ? 1 : value + 1);
            } else if (command == 2) {
                Integer occurrenceToRemove = counter.get(number);
                if (occurrenceToRemove != null && occurrenceToRemove != 0) {
                    counter.compute(number, (key, value) -> value - 1);
                }
            } else {
                boolean validMatch = counter.values().stream().anyMatch(value -> value == number);
                if (validMatch) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }

}
