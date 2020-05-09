import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long tripletCounter(List<Long> numbers, long ratio) {
        long numberOfTriplets = 0;
        Map<Long, Long> countPerNumber = convertListToHashmap(numbers);
        for (Long number : countPerNumber.keySet()) {
            long multipliedOnce = number * ratio;
            long multipliedTwice = number * ratio * ratio;
            long firstMemberOccurance = countPerNumber.get(number);
            long secondMemberOccurance = countPerNumber.get(number * ratio) == null ? 0 : countPerNumber.get(number * ratio);
            long thirdMemberOccurance = countPerNumber.get(number * ratio * ratio) == null ? 0 : countPerNumber.get(number * ratio * ratio);
            numberOfTriplets += firstMemberOccurance * secondMemberOccurance * thirdMemberOccurance;
        }
        return numberOfTriplets;
    }

    private static Map<Long, Long> convertListToHashmap(List<Long> arr) {
        Map<Long, Long> numbersWithOccurance = new HashMap<>();
        for (Long number : arr) {
            if (numbersWithOccurance.containsKey(number)) {
                numbersWithOccurance.put(number, numbersWithOccurance.get(number) + 1);
            } else {
                numbersWithOccurance.put(number, 1L);
            }
        }
        return numbersWithOccurance;
    }

}
