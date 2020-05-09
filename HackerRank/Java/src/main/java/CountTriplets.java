import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long tripletCounter(List<Long> numbers, long ratio) {
        long numberOfTriplets = 0;
        Map<Long, Long> countPerNumber = countNumbersInList(numbers);
        for (Long number : countPerNumber.keySet()) {
            long multipliedOnce = number * ratio;
            long multipliedTwice = number * ratio * ratio;

            long firstMemberOccurance = countPerNumber.get(number);
            long secondMemberOccurance = countPerNumber.get(multipliedOnce) == null ? 0 : countPerNumber.get(multipliedOnce);
            long thirdMemberOccurance = countPerNumber.get(multipliedTwice) == null ? 0 : countPerNumber.get(multipliedTwice);
            numberOfTriplets += firstMemberOccurance * secondMemberOccurance * thirdMemberOccurance;
        }
        return numberOfTriplets;
    }

    private static Map<Long, Long> countNumbersInList(List<Long> numbers) {
        Map<Long, Long> countPerNumber = new HashMap<>();
        for (Long number : numbers) {
            if (countPerNumber.containsKey(number)) {
                countPerNumber.put(number, countPerNumber.get(number) + 1);
            } else {
                countPerNumber.put(number, 1L);
            }
        }
        return countPerNumber;
    }
}
