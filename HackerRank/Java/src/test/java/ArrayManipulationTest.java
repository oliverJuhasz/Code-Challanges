import ArrayManipulation.ArrayManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayManipulationTest {

    @ParameterizedTest
    @CsvSource({"5 1 2 100 2 5 100 3 4 100,200", "10 1 5 3 4 8 7 6 9 1, 10", "10 2 6 8 3 5 7 1 8 1 5 9 15, 31"})
    @DisplayName("sherlockAndAnagrams returns the correct number of anagrams for each string")
    public void test1(String input, int expected) {
        // GIVEN
        String[] rawInput = input.split(" ");
        int[][] queries = new int[rawInput.length / 3][3];
        int arrayLength = Integer.parseInt(rawInput[0]);
        for (int i = 0; i < rawInput.length / 3; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = Integer.parseInt(rawInput[(i * 3) + j + 1]);
            }
        }

        // WHEN
        long result = ArrayManipulation.arrayManipulation(arrayLength, queries);

        // THEN
        assertEquals(expected, result);

    }

}
