import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> numbers, long ratio){
        Map<Long,Long> leftPart = new HashMap<>();
        Map<Long,Long> midPart = new HashMap<>();
        long numberOfTriplets = 0L;
        for (Long number : numbers) {
            numberOfTriplets += midPart.getOrDefault(number, 0L);
            addMidPartIfLeftPartExists(ratio, leftPart, midPart, number);
            addOrIncrementLeftPart(ratio, leftPart, number);
        }
        return numberOfTriplets;
    }

    private static void addMidPartIfLeftPartExists(long ratio, Map<Long, Long> leftPart, Map<Long, Long> midPart, Long number) {
        if (leftPart.get(number)!=null) {
            midPart.compute(number * ratio, (key,value) -> value != null ? value + leftPart.get(number) : leftPart.get(number));
        }
    }

    private static void addOrIncrementLeftPart(long ratio, Map<Long, Long> leftPart, Long number) {
        leftPart.compute(number * ratio, (key,value) -> value == null ? 1 : value + 1);
    }
}
