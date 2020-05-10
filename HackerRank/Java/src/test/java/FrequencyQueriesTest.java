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
        List<List<Integer>> input = List.of(List.of(1, 5), List.of(1, 6), List.of(3, 2), List.of(1, 10),
                List.of(1, 10), List.of(1, 6), List.of(2, 5), List.of(3, 2));

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1), result);
    }

    @Test
    public void test2() {
        // GIVEN
        List<List<Integer>> input = List.of(List.of(3, 4), List.of(2, 1003), List.of(1, 16), List.of(3, 1));

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1), result);
    }

    @Test
    public void test3() {
        // GIVEN
        List<List<Integer>> input = List.of(List.of(1, 3), List.of(2, 3), List.of(3, 2), List.of(1, 4),
                List.of(1, 5), List.of(1, 5), List.of(1, 4), List.of(3, 2), List.of(2, 4), List.of(3, 2));

        // WHEN
        List<Integer> result = FrequencyQueries.freqQuery(input);

        // WHEN
        assertEquals(List.of(0, 1, 1), result);
    }

    @Test
    public void test4() {
        // GIVEN
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> expectedOutput = new ArrayList<>();
        try {
            Scanner scanner  = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("FrequenciesTest/FrequenciesTestInput")).getFile()));
            while (scanner.hasNextLine()) {
                queries.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
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
