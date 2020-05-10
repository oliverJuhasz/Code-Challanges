import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    @DisplayName("100 * 1 with ratio of 1")
    @Test
    public void test4() {
        // GIVEN
        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(1L);
        }
        long ratio = 1;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(161700, result);
    }

    @DisplayName("Numbers from TripletsTest1 with ratio of 3")
    @Test
    public void test5() {
        // GIVEN
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(getClass().getClassLoader().getResource("TripletsTest1").getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String numbersAsString = scanner.nextLine();
        String[] stringArr = numbersAsString.split(" ");

        List<Long> numbers = Arrays.stream(stringArr).map(Long::valueOf).collect(Collectors.toList());
        long ratio = 3;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(2325652489L, result);
    }

    @DisplayName("1, 2, 1, 2, 4 with ratio of 2")
    @Test
    public void test6() {
        // GIVEN
        List<Long> numbers = List.of(1L, 2L, 1L, 2L, 4L);
        long ratio = 2;

        // WHEN
        long result = CountTriplets.countTriplets(numbers, ratio);

        // WHEN
        assertEquals(3, result);
    }


}
