import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountTripletsTest {

    @DisplayName("1, 2, 2, 4 with ratio of 2")
    @Test
    public void test1() {
        // GIVEN
        List<Long> numbers = List.of(1L, 2L, 2L, 4L);
        long ratio = 2;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(2, result);
    }

    @DisplayName("1, 3, 9, 9, 27, 81 with ratio of 3")
    @Test
    public void test2() {
        // GIVEN
        List<Long> numbers = List.of(1L, 3L, 9L, 9L, 27L, 81L);
        long ratio = 3;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(6, result);
    }

    @DisplayName("1, 5, 5, 25, 125 with ratio of 5")
    @Test
    public void test3() {
        // GIVEN
        List<Long> numbers = List.of(1L, 5L, 5L, 25L, 125L);
        long ratio = 5;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(4, result);
    }

}
