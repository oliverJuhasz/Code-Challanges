package SeatingStudents;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeatingStudentsExercise {

    public static int SeatingStudents(int[] input) {
        int possibleCombinations = 0;
        int numberOfSeating = input[0];
        Set<Integer> occupiedDesks = new HashSet<>();
        Arrays.stream(input)
                .skip(1L)
                .forEach(occupiedDesks::add);
        boolean evenDeskNumber = true;
        for (int i = 1; i < numberOfSeating; i += evenDeskNumber ? 3 : 1) {
            if (occupiedDesks.contains(i + 1)) {
                evenDeskNumber = !evenDeskNumber;
                continue;
            }
            if (evenDeskNumber) {
                if (i - 2 >= 0) {
                    possibleCombinations += occupiedDesks.contains(i - 1) ? 0 : 1;
                }
                if (i + 1 <= numberOfSeating) {
                    possibleCombinations += occupiedDesks.contains(i) ? 0 : 1;
                }
                if (i + 2 <= numberOfSeating) {
                    possibleCombinations += occupiedDesks.contains(i + 3) ? 0 : 1;
                }
                evenDeskNumber = false;
            } else {
                possibleCombinations += occupiedDesks.contains(i - 1) ? 0 : 1;
                possibleCombinations += occupiedDesks.contains(i + 2) ? 0 : 1;
                if (i + 2 < numberOfSeating) {
                    possibleCombinations += occupiedDesks.contains(i + 3) ? 0 : 1;
                }
                evenDeskNumber = true;
            }
        }
        return possibleCombinations;
    }


}
