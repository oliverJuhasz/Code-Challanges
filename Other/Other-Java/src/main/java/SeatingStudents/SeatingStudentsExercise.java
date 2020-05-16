package SeatingStudents;

import java.util.*;

public class SeatingStudentsExercise {

    /** There are two columns of desks in the room. Some desks are occupied. Calculate the number of ways two people can
     * sit next to each other (vertically or horizontally).
     *
     * @param input - index 0 is the number of desks (must be even). The rest of the numbers are the occupied desks
     * @return
     */
    public static int SeatingStudents(int[] input) {
        int possibleCombinations = 0;
        int numberOfSeating = input[0];
        Set<Integer> invalidDeskIndexes = calculateInvalidDeskIndexes(input, numberOfSeating);
        boolean isDeskIndexOdd = true;

        for (int i = 1; i < numberOfSeating; i += isDeskIndexOdd ? 3 : 1) {
            boolean isExaminedDeskOccupied = invalidDeskIndexes.contains(i);
            if (!isExaminedDeskOccupied) {
                possibleCombinations += getNumberOfSeatingCombinationsForSeat(isDeskIndexOdd, i, invalidDeskIndexes);
            }
            isDeskIndexOdd = !isDeskIndexOdd;
        }
        return possibleCombinations;
    }

    private static Set<Integer> calculateInvalidDeskIndexes(int[] input, int numberOfSeating) {
        Set<Integer> invalidDeskIndexes = new HashSet<>();
        Arrays.stream(input)
                .skip(1L)
                .map(value -> value - 1)
                .forEach(invalidDeskIndexes::add);
        invalidDeskIndexes.add(-1);
        invalidDeskIndexes.add(numberOfSeating);
        invalidDeskIndexes.add(numberOfSeating + 1);
        return invalidDeskIndexes;
    }

    private static int getNumberOfSeatingCombinationsForSeat(boolean isDeskIndexOdd, int i, Set<Integer> invalidDeskIndexes) {
        int possibleCombinations = 0;
        if (isDeskIndexOdd) {
            possibleCombinations += invalidDeskIndexes.contains(i - 2) ? 0 : 1;
            possibleCombinations += invalidDeskIndexes.contains(i - 1) ? 0 : 1;
            possibleCombinations += invalidDeskIndexes.contains(i + 2) ? 0 : 1;
        } else {
            possibleCombinations += invalidDeskIndexes.contains(i - 2) ? 0 : 1;
            possibleCombinations += invalidDeskIndexes.contains(i + 1) ? 0 : 1;
            possibleCombinations += invalidDeskIndexes.contains(i + 2) ? 0 : 1;
        }
        return possibleCombinations;
    }


}
