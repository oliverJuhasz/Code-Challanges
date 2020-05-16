import SherlockAndAnagrams.SherlockAndAnagrams;
import SparseArrays.SparseArrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SparseArraysTest {

    @ParameterizedTest
    @CsvSource({"aba baba aba xzxb,aba xzxb ab,2 1 0",
            "def de fgh,de lmn fgh,1 0 1",
            "abcde sdaklfj asdjf na basdn sdaklfj asdjf na asdjf na basdn sdaklfj asdjf,abcde sdaklfj asdjf na basdn,1 3 4 3 2"})
    @DisplayName("matchingStrings returns the correct number of occurances in input string")
    public void test1(String rawInput1, String rawInput2, String rawInput3) {
        // GIVEN
        String[] words = rawInput1.split(" ");
        String[] queries = rawInput2.split(" ");
        String[] resultsInString = rawInput3.split(" ");
        int[] expectedResults = Arrays.stream(resultsInString).mapToInt(Integer::parseInt).toArray();

        // WHEN
        int[] actualResults = SparseArrays.matchingStrings(words, queries);

        // WHEN
        assertArrayEquals(expectedResults, actualResults);
    }
}
