package SeatingStudents;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeatingStudentsExercise {

    public static int SeatingStudents(int[] input) {
        int possibleCombinations = 0;
        int numberOfSeating = input[0];
        Set<Integer> invalidDeskIndexes = new HashSet<>();
        Arrays.stream(input)
                .skip(1L)
                .map(value -> value - 1)
                .forEach(invalidDeskIndexes::add);
        invalidDeskIndexes.addAll(List.of(-1, numberOfSeating, numberOfSeating + 1));
        boolean isDeskIndexOdd = true;
        for (int i = 1; i < numberOfSeating; i += isDeskIndexOdd ? 3 : 1) {
            boolean isExaminedDeskOccupied = invalidDeskIndexes.contains(i);
            if (!isExaminedDeskOccupied) {
                possibleCombinations += getNumberOfSeatingCombinationForSeat(isDeskIndexOdd, i, invalidDeskIndexes);
            }
            isDeskIndexOdd = !isDeskIndexOdd;
        }
        return possibleCombinations;
    }

    private static int getNumberOfSeatingCombinationForSeat(boolean isDeskIndexOdd, int i, Set<Integer> invalidDeskIndexes) {
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
