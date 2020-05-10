import CountTriplets.CountTriplets;
import SherlockAndAnagrams.SherlockAndAnagrams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndAnagramsTest {

    @ParameterizedTest
    @CsvSource({"abba,4", "abcd, 0", "ifailuhkqq,3", "kkkk,10", "cdcd,5"})
    @Test()
    @DisplayName("sherlockAndAnagrams returns the correct number of anagrams for each string")
    public void test1(String input, int expected) {
        // GIVEN in parameters

        // WHEN
        long result = SherlockAndAnagrams.sherlockAndAnagrams(input);

        // WHEN
        assertEquals(expected, result);
    }

}
