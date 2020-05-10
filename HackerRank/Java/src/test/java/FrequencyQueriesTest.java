import FrequencyQueries.FrequencyQueries;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
