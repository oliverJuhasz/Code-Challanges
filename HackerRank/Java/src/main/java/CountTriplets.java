import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long tripletCounter(List<Long> arr, long r) {
        long numberOfTriplets = 0;
        Map<Long, Long> numbersWithOccurance;
        numbersWithOccurance = convertListToHashmap(arr);
        for (Long number : numbersWithOccurance.keySet()) {
            long powerOfTwo = number * r;
            long powerOfThree = number * r * r;
            Long numberOfPossibleSecondStep = numbersWithOccurance.get(powerOfTwo);
            Long numberOfPossibleThirdStep = numbersWithOccurance.get(powerOfThree);
            if (numberOfPossibleSecondStep != null && numberOfPossibleThirdStep != null && numberOfPossibleSecondStep > 0 && numberOfPossibleThirdStep > 0) {
                numberOfTriplets += numbersWithOccurance.get(number) * numberOfPossibleSecondStep * numberOfPossibleThirdStep;
            }
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
