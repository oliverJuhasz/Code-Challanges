import SeatingStudents.SeatingStudentsExercise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeatingStudentsTest {

    @DisplayName("Test with one occupied desk")
    @Test
    public void test1() {
        // GIVEN
        int[] input = new int[]{6, 4};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(4, result);
    }

    @DisplayName("Test with two occupied desks")
    @Test
    public void test2() {
        // GIVEN
        int[] input = new int[]{8, 1, 8};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(6, result);
    }

    @DisplayName("None of the desks are occupied desks")
    @Test
    public void test3() {
        // GIVEN
        int[] input = new int[]{12};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(16, result);
    }

    @DisplayName("All desks are occupied")
    @Test
    public void test4() {
        // GIVEN
        int[] input = new int[]{6, 1, 2, 3, 4, 5, 6};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(0, result);
    }

    @DisplayName("Example exercise")
    @Test
    public void test5() {
        // GIVEN
        int[] input = new int[]{12, 2, 6, 7, 11};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(6, result);
    }

    @DisplayName("First and last two seats occupied")
    @Test
    public void test6() {
        // GIVEN
        int[] input = new int[]{6, 1, 2, 5, 6};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(1, result);
    }

    @DisplayName("Seats are occupied in a way which prevents sitting next to each other")
    @Test
    public void test7() {
        // GIVEN
        int[] input = new int[]{6, 1, 4, 5};

        // WHEN
        int result = SeatingStudentsExercise.SeatingStudents(input);

        // WHEN
        assertEquals(0, result);
    }

}
