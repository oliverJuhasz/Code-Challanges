import FrequencyQueries.FrequencyQueries;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FrequencyQueriesTest {

    @Test
    public void test1() {
        // GIVEN
        int[][] input = {{1, 5}, {1, 6}, {3, 2}, {1, 10},
            {1, 10}, {1, 6}, {2, 5}, {3, 2}};

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1), result);
    }

    @Test
    public void test2() {
        // GIVEN
        int[][] input = {{3, 4}, {2, 1003}, {1, 16}, {3, 1}};

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1), result);
    }

    @Test
    public void test3() {
        // GIVEN
        int[][] input = {{1, 3}, {2, 3}, {3, 2}, {1, 4},
                {1, 5}, {1, 5}, {1, 4}, {3, 2}, {2, 4},{3, 2}};

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1, 1), result);
    }

    @Test
    public void test4() {
        // GIVEN
        int[][] queries = new int[100000][2];
        List<Integer> expectedOutput = new ArrayList<>();
        try {
            Scanner scanner  = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("FrequenciesTest/FrequenciesTestInput")).getFile()));
            int i = 0;
            while (scanner.hasNextLine()) {
                queries[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                i++;
            }
            scanner.close();
            scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("FrequenciesTest/FrequenciesTestOutput")).getFile()));
            while (scanner.hasNextLine()) {
                expectedOutput.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            fail("Test file not found");
        }
        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(queries);

        // WHEN
        assertEquals(expectedOutput, result);
    }

}
